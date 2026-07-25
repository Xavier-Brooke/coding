const express = require("express") ;
const path = require("path") ;

const app = express() ;
const port = 3000 ;

let igData = require("./data.json") ;

app.use(express.urlencoded({extended:true})) ;
app.use(express.json()) ;
app.use(express.static(path.join(__dirname, "public"))) ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "/views")) ;

app.get("/ig", (req, res) => {
    res.render("home.ejs") ;
})

app.get("/ig/:user", (req, res) => {
    let { user } = req.params ;
    let userData = igData[user] ;
    if(userData) {
        return res.render("user.ejs", { userData }) ;
    }
    return res.render("error.ejs") ;
})

app.post("/ig/:user/follow", (req, res) => {
    let { user } = req.params ;
    let userData = igData[user] ;
    if(userData) {
        userData.followers += 1 ;
        return res.redirect(`/ig/${user}`) ;
    }
    res.send("something went wrong..").status(404) ;
})

app.get(/.*/, (req, res) => {
    res.status(404).send("Page not found!") ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})