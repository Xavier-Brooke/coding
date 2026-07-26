const {faker} = require("@faker-js/faker") ;
const mysql = require("mysql2") ;
const express = require("express") ;
const path = require("path") ;
const { v4 : uuid } = require("uuid") ;
const methodOverride = require("method-override") ;

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  database: 'delta_app',
});

const app = express() ;
const port = 3000 ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "/views")) ;

app.use(express.urlencoded({extended:true})) ;
app.use(express.json()) ;
app.use(express.static(path.join(__dirname, "public"))) ;
app.use(methodOverride("_method")) ;

app.get("/", (req, res) => {
    let q = "SELECT COUNT(*) FROM user" ;
    try {
        connection.query(q, (err, result) => {
            if(err) throw err ;
            let users = result[0]["COUNT(*)"] ;
            res.render("home.ejs", {users}) ; 
        })
    } catch(err) {
        console.log(`Something went wrong..`) ;
        console.error(err) ;
        res.send("error.ejs") ;
    }
})

app.get("/users", (req, res) => {
    let q = "SELECT * FROM user" ;
    try {
        connection.query(q, (err, result) => {
            if(err) throw err ;
            res.render("users.ejs", {result}) ;
        })
    } catch(err) {
        console.log(`Something went wrong..`) ;
        console.error(err) ;
        res.render("error.ejs") ;
    }
})

app.get("/users/newUser", (req, res) => {
    res.render("newUser.ejs") ;
})

app.post("/users", (req, res) => {
    let { username, email, password } = req.body ;
    let id = uuid() ;
    let q = "INSERT INTO user (userId, username, email, password) VALUES (?, ?, ?, ?)" ;
    let user = [id, username, email, password] ;
    
    try {
        connection.query(q, user, (error, result) => {
            if(error) throw error ;
            console.log(result) ;
            res.redirect("/users") ;
        })
    } catch(error) {
        console.log(`Something went wrong..`) ;
        console.error(error) ;
        res.render("error.ejs") ;
    }
})

// user details
app.get("/users/details/:userId", (req, res) => {
    let { userId } = req.params ;
    let q = `SELECT * FROM user WHERE userId = "${userId}"` ;
    try {
        connection.query(q, (error, result) => {
            if(error) throw error ;
            if(result) {
                res.render("details.ejs", {result}) ;
            } else {
                res.render("error.ejs") ;
            }
        })
    } catch(error) {
        console.log(`Something went wrong...`) ;
        console.error(error) ;
        res.send("something went wrong (/user/details)") ;
    }
})

// edit url (get)
app.get("/users/edit/:userId", (req, res) => {
    let { userId } = req.params ;
    let q = `SELECT * FROM user WHERE userId = "${userId}"` ;
    try {
        connection.query(q, (error, result) => {
            if(error) throw error ;
            if(result) {
                res.render("edit.ejs", {result}) ;
            } else {
                res.render("error.ejs") ;
            }
        })
    } catch(error) {
        console.log(`Something went wrong...`) ;
        console.error(error) ;
        res.render("error.ejs") ;
    }
})

// edit url (post)
app.patch("/users/:userId", (req, res) => {
    let {userId} = req.params ;
    console.log(req.body) ;
    let { username, email, password } = req.body ;
    let q = `UPDATE user SET username = "${username}", email = "${email}", password = "${password}" WHERE userId = "${userId}"`
    try {
        connection.query(q, (error, result) => {
            if(error) throw error ;
            console.log("Data updated successfully") ;
            res.redirect("/users") ;
        })
    } catch(error) {
        console.log(`Something went wrong...`) ;
        console.error(error) ;
        res.send("Can't patch user") ;
    }
})

// deleting user
app.delete("/users/delete/:userId", (req, res) => {
    let { userId } = req.params ;
    let q = `DELETE FROM user WHERE userId = "${userId}"` ;
    try{
        connection.query(q, (error, result) => {
            if(error) throw error ;
            res.redirect("/users") ;
        })
    } catch(error) {
        console.log(`Something went wrong...`) ;
        console.error(error) ;
        res.send(`Can't delete user`) ;
    }
})

// handling invalid url using wild card
app.get(/.*/, (req, res) => {
    res.status(404).render("pageNotFound.ejs") ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})

// connection.end() ;

/*  Creating fake data and pushing it into database
let data = [] ;

let getRandomUser = () => {
    return [
        faker.string.uuid(),
        faker.internet.username(),
        faker.internet.email(),
        faker.internet.password(),
    ];
}

for(let i = 1; i <= 100; i++) {
    data.push(getRandomUser()) ;
}

let q = "INSERT INTO user (userId, username, email, password) VALUES ?" ;

try {
    connection.query(q, [data], (error, result) => {
        if(error) throw error ;
        console.log(result) ;
    })
} catch(error) {
    console.log(`SOMETHING WENT WRONG...`) ;
    console.error(error) ;
}
*/