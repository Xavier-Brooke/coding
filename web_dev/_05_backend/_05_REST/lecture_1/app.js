const express = require("express") ;
const methodOverride = require("method-override") ;
const path = require("path") ;
const data = require("./public/data/data") ;

const app = express() ;
const port = 3000 ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "/views")) ;

app.use(express.static(path.join(__dirname, "public"))) ;

app.get("/filmyWorld", (req, res) => {
    res.render("home.ejs", {data}) ;
})

app.get("/filmyWorld/new", (req, res) => {
    res.render("newPost.ejs") ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})