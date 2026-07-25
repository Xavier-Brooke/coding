const path = require("node:path") ;
const express = require("express") ;
const { faker, fa } = require("@faker-js/faker") ;
const methodOverride = require("method-override") ;

let data = require("../public/utils/data") ;

const app = express() ;
const port = 8000 ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "../views")) ;

app.use(express.json()) ;
app.use(methodOverride("_method")) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.static(path.join(__dirname, "../public"))) ;

app.get("/api", (req, res) => {
    res.render("home.ejs", { data }) ;
})

app.get("/api/newPost", (req, res) => {
    res.render("newPost.ejs") ;
})

app.post("/api", (req, res) => {
    let { name, msg } = req.body ;
    let id = faker.string.uuid() ;
    let date = faker.date.anytime() ;

    if(name && msg) {
        data.push({id, name, msg, date}) ;
        return res.redirect("/api") ;
    }
    
    return res.redirect("errors/invalidInputError") ;
})

app.get("/api/:id/details", (req, res) => {
    let { id } = req.params ;
    let user = data.find((ele) => ele.id == id) ;
    
    if(user) {
        let day = user.date.toString().split(" ").slice(1, 4).join(" ") ;
        let time = user.date.toString().split(" ").slice(4, 5).join(" ") ;
        return res.render("details.ejs", { user, day, time }) ;
    }

    return res.status(400).render("errors/accountNotFoundError") ;
})

app.get("/api/:id/edit", (req, res) => {
    let { id } = req.params ;
    let user = data.find((ele) => ele.id == id) ;

    if(user) {
        let { id, name, msg } = user ;
        return res.render("edit.ejs", { id, name, msg }) ;
    }

    return res.status(400).render("errors/accountNotFoundError") ;
})

app.patch("/api/:id", (req, res) => {
    let { id } = req.params ;
    let user = data.find((ele) => ele.id == id) ;

    if(user) {
        let { name : updatedName, msg : updatedMsg } = req.body ;
        user.name = updatedName ;
        user.msg = updatedMsg ;
        return res.redirect("/api") ;
    }

    return res.status(400).render("errors/accountNotFoundError") ;
})

app.delete("/api/:id/delete", (req, res) => {
    let { id } = req.params ;
    let user = data.find((ele) => ele.id == id) ;

    if(user) {
        data = data.filter((ele) => ele.id != id) ;
        return res.redirect("/api") ;
    }

    return res.status(400).render("errors/accountNotFoundError") ;
})

app.get(/.*/, (req, res) => {
    return res.status(400).render("errors/pageNotFoundError") ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})