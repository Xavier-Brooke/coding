const path = require("path") ;
const express = require("express") ;
const mongoose = require("mongoose") ;
const Chat = require("./models/chats.js") ;
const ExpressError = require("./expressError.js") ;
const methodOverride = require("method-override") ;

main()
    .then(() => {
        console.log("Successfully connected to database.") ;
    })
    .catch((error) => {
        console.log("Something went wrong...") ;
        console.error(error) ;
    })

async function main() {
    await mongoose.connect("mongodb://127.0.0.1:27017/errorDemo")
}

const app = express() ;
const port = 3000 ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "/views")) ;

app.use(express.json()) ;
app.use(methodOverride("_method")) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.static(path.join(__dirname, "public"))) ;

app.get("/chats", async function(req, res) {
    let chats = await Chat.find() ;
    res.render("index.ejs", {chats}) ;
})

app.get("/chats/new", (req, res) => {
    throw new ExpressError() ;
    res.render("new.ejs") ;
})

app.post("/chats", async function(req, res) {
    let { from, to, msg } = req.body ;
    let date = new Date() ;
    let result = await Chat.insertOne({from, to, msg, created_at : date}) ;
    console.log(result) ;
    res.redirect("/chats") ;
})

app.get("/chats/:id/edit", async (req, res, next) => {
    let { id } = req.params ;
    let chats = await Chat.findById(id) ;
    if(!chats) {
        next(new ExpressError(402, "CHAT NOT FOUND", "ENTER A VALID ID")) ;
    }
    res.render("edit.ejs", {chats}) ;
})

app.put("/chats/:id", async (req, res) => {
    let { id } = req.params ;
    let { msg : newMsg} = req.body ;
    let chats = await Chat.findByIdAndUpdate(id, {msg : newMsg}) ;
    res.redirect("/chats") ;
})

app.delete("/chats/:id/delete", async (req, res) => {
    let { id } = req.params ;
    await Chat.findByIdAndDelete(id) ;
    res.redirect("/chats") ;
})

app.use((err, req, res, next) => {
    let { status=404, message="PAGE NOT FOUND", hint="ENTER VALID REQUEST"} = err ;
    let code = `<div style="height:200px; width:500px; border:1px solid black; background-color:orange">
                    <h1 style="color:red;">Error Occurred</h1>
                    <h4>Error Status :- ${status}</h4>
                    <h4>Message :- ${message}</h4>
                    <h4>Hint :- ${hint}</h4>
                </div>` ;
    res.status(status).send(code) ;
    next(err) ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})