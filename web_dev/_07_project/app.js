const path = require("node:path") ;
const express = require("express") ;
const mongoose = require("mongoose") ;
const Listing = require("./models/listing") ;
const methodOverride = require("method-override") ;

const MONGO_URL = 'mongodb://127.0.0.1:27017/wanderlust' ;

async function main() {
    await mongoose.connect(MONGO_URL) ;
}

main()
    .then(() => {
        console.log(`Successfully Connected to DB`) ;
    })
    .catch((err) => {
        console.log(`Some error occured in DB`) ;
        console.error(err) ;
    })

const app = express() ;
const port = 8000 ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "/views")) ;

app.use(express.json()) ;
app.use(methodOverride("_method")) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.static(path.join(__dirname, "/public"))) ;

app.get("/", (req, res) => {
    return res.send("This is root route") ;
})

app.get("/listings", async (req, res) => {
    let allListings = await Listing.find({}) ;
    return res.render("listings/index", { allListings }) ;
})

app.get(/.*/, (req, res) => {
    let code = [
        '<div style="background-color:orange; height:300px; width:450px; border:1px solid black;">',
            '<p style="color:black; font-weight:bold;">PAGE NOT FOUND</p>',
        '</div>'
    ].join(' ') ;

    return res.send(code) ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})