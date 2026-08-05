const mongoose = require("mongoose") ;
const Chat = require("./models/chats.js") ;

async function main() {
    await mongoose.connect("mongodb://127.0.0.1:27017/whatsapp") ;
}

main()
.then(() => {
    console.log("Successfully connected to database.") ;
})
.catch((error) => {
    console.log("Something went wrong...") ;
    console.error(error) ;
})

let chats = [
    {
        from: "neha",
        to: "preeti",
        msg: "send me notes for the exam",
        created_at: new Date()
    },
    {
        from: "rohit",
        to: "mohit",
        msg: "teach me JS callbacks",
        created_at: new Date()
    },
    {
        from: "simran",
        to: "raj",
        msg: "are we meeting today?",
        created_at: new Date()
    },
    {
        from: "anita",
        to: "deepak",
        msg: "please review my code",
        created_at: new Date()
    },
    {
        from: "sunil",
        to: "ritu",
        msg: "happy birthday!",
        created_at: new Date()
    }
] ;

Chat.insertMany(chats)
.then(() => {
    console.log("Data added") ;
})
.catch((error) => {
    console.log("Error occurred...") ;
    console.error(error) ;
})