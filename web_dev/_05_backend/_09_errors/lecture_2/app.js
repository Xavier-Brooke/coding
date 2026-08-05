const express = require("express") ;
const path = require("path") ;
const methodOverride = require("method-override") ;
const mongoose = require("mongoose") ;
const Chat = require("./models/chats.js") ;

main()
    .catch((e) => {console.error(e)}) ;

async function main() {
    await mongoose.connect("mongodb://127.0.0.1:27017/whatsapp")
}

const app = express() ;
const port = 3000 ;

app.set("view engine", "ejs") ;
app.set("views", path.join(__dirname, "/views")) ;

app.use(express.static(path.join(__dirname, "public"))) ;
app.use(methodOverride("_method")) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.json()) ;

app.get("/chats", async function(req, res) {
    let chats = await Chat.find() ;
    res.render("index.ejs", {chats}) ;
})

app.get("/chats/new", (req, res) => {
    res.render("new.ejs") ;
})

app.post("/chats", async function(req, res) {
    let { from, to, msg } = req.body ;
    let date = new Date() ;
    let result = await Chat.insertOne({from, to, msg, created_at : date}) ;
    console.log(result) ;
    res.redirect("/chats") ;
})

app.get("/chats/:id/edit", async (req, res) => {
    let { id } = req.params ;
    let chats = await Chat.findById(id) ;
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

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})