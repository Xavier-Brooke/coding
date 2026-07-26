const mysql = require("mysql2") ;
const util = require("node:util") ;
const path = require("node:path") ;
const express = require("express") ;
const { v4 : uuid } = require("uuid") ;
const methodOverride = require("method-override") ;

const connections = mysql.createConnection({
    host : "localhost",
    user : "root",
    database : "test",
}) ;

const query = util.promisify(connections.query).bind(connections) ;

const app = express() ;
const port = 8000 ;

app.use(express.json()) ;
app.use(methodOverride("_method")) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.static(path.join(__dirname, "../public"))) ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "../views")) ;

// rendering home page
app.get("/api", async (req, res) => {
    try {
        let q = `SELECT COUNT(*) FROM user` ;
        let result = await query(q) ;
        let count = result[0]["COUNT(*)"] ;
        return res.render("home.ejs", { count }) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render("errors/databaseError") ;
    }
})

// rendering users page
app.get("/api/users", async (req, res) => {
    try {
        let q = `SELECT * FROM user` ;
        let result = await query(q) ;
        let users = result ;
        return res.render("users.ejs", { users }) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render("errors/databaseError") ;
    }
})

// rendering newUser page
app.get("/api/newUser", (req, res) => {
    return res.render("newUser.ejs") ;
})

// collecting data
app.post("/api", async (req, res) => {
    try {
        let { userName, email, password, msg } = req.body ;
        let q = `INSERT INTO user (id, userName, email, msg, password) VALUES (?, ?, ?, ?, ?)` ;
        let result = await query(q, [ uuid(), userName, email, msg, password]) ;
        return res.redirect("/api") ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render("errors/databaseError") ;
    }
})

// rendering details page
app.get("/api/:id/details", async (req, res) => {
    try {
        let { id } = req.params ;
        let q = `SELECT * FROM user WHERE id = ?` ;
        let result = await query(q, id) ;
        let { id : ID, userName, email, msg } = result[0] ;
        return res.render("details.ejs", { ID, userName, email, msg }) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render("errors/databaseError") ;
    }
})

// rendering edit page
app.get("/api/:id/edit", async (req, res) => {
    try {
        let { id } = req.params ;
        let q = `SELECT * FROM user WHERE id = ?` ;
        let result = await query(q, id) ;
        let { id : ID, userName, email, msg } = result[0] ;
        return res.render("edit.ejs", { ID, userName, email, msg }) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render("errors/databaseError") ;
    }
})

// collecting data 
app.patch("/api/:id", async (req, res) => {
    try {
        let { id } = req.params ;
        let { email, msg } = req.body ;
        let q = `UPDATE user SET email = ?, msg = ? WHERE id = ?` ;
        let result = await query(q, [ email, msg, id ]) ;
        return res.redirect("/api/users") ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render("errors/databaseError") ;
    }
})

// rendering page for password conformation
app.get("/api/:id/delete", (req, res) => {
    let { id } = req.params ;
    return res.render("delete.ejs", { id }) ;
})

// deleting user
app.delete("/api/:id", async (req, res) => {
    try {
        let { id } = req.params ;
        let { password : enteredPassword } = req.body ;
        let q = `SELECT password FROM user WHERE id = ?` ;
        let result = await query(q, id) ;
        let password = result[0].password ;
        if(enteredPassword == password) {
            let deleteQuery = `DELETE FROM user WHERE password = ?` ;
            let deletedResult = await query(deleteQuery, enteredPassword) ;
            return res.redirect("/api") ;
        }

        return res.render("errors/invalidPasswordError") ;

    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render("errors/databaseError") ;
    }
})

app.get(/.*/, (req, res) => {
    return res.render("errors/pageNotFound") ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})