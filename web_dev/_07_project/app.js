const path = require("node:path") ;
const express = require("express") ;
const engine = require("ejs-mate") ;
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

app.engine('ejs', engine);
app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "/views")) ;

app.use(express.json()) ;
app.use(methodOverride("_method")) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.static(path.join(__dirname, "/public"))) ;

app.get("/", (req, res) => {
    return res.send("This is root route") ;
})

// all lisings
app.get("/listings", async (req, res) => {
    try {
        let data = await Listing.find({}) ;
        let allListings = data ?? "invalid" ;
        if(allListings !== "invalid") {
            return res.render("listings/index", { allListings }) ;
        }
        return res.render("errors/dataNotFound") ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
    }
})

// details route
app.get("/listings/:id/details", async (req, res) => {
    try {
        let { id } = req.params ;
        let data = await Listing.findById(id) ;
        let listing = data ?? "invalid" ;
        if(listing !== "invalid") {
            return res.render("listings/details", { listing }) ;
        }
        return res.render("errors/dataNotFound") ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
    }
})

// new listing
app.get("/listings/new", (req, res) => {
    return res.render("listings/new") ;
})

// collecting data
app.post("/listings", async (req, res) => {
    try {
        let data = req.body.listing ;
        let { imgURL } = req.body ;
        let obj = { ...data, image : {
            url : imgURL,
        }}
        let ans = await Listing.insertOne(obj) ;
        return res.redirect("/listings") ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
    }
})

// edit route
app.get("/listings/:id/edit", async (req, res) => {
    try {
        let { id } = req.params ;
        let data = await Listing.findById(id) ;
        let listing = data ?? "invalid" ;
        if(listing !== "invalid") {
            return res.render("listings/edit", { listing }) ;
        }
        return res.render("errors/dataNotFound") ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
    }
})

app.put("/listings/:id", async (req, res) => {
    try {
        let { id } = req.params ;
        let data = req.body.listing ;
        let { imgURL } = req.body ;
        let obj = { ...data, "image.url" : imgURL}
        console.log(obj) ;
        let ans = await Listing.findByIdAndUpdate(id, obj) ;
        console.log(ans) ;
        return res.redirect("/listings") ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
    }
})

// delete route
app.delete("/listings/:id/delete", async (req, res) => {
    try {
        let { id } = req.params ;
        let ans = await Listing.findByIdAndDelete(id) ;
        return res.redirect("/listings") ;
    } catch(err) {
        console.log(`Something went wrong..`) ;
        console.error(err) ;
    }
})

// wild request
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