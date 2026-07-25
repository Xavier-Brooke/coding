const path = require("node:path") ;
const express = require("express") ;
const flipCoin = require("../public/utils/flipCoin") ;

const app = express() ;
const port = 8000 ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "../views")) ;

app.use(express.static(path.join(__dirname, "../public"))) ;

app.get("/api", (req, res) => {
    res.render("home.ejs") ;
})

app.get("/api/flipCoin", (req, res) => {
    let result = flipCoin() ;
    res.render("flipCoin.ejs", { result }) ;
})

app.get("/api/colorGenerator", (req, res) => {
   res.render("colorGenerator.ejs") ;
})

app.get(/.*/, (req, res) => {
    res.send("PAGE NOT FOUND").status(404) ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})