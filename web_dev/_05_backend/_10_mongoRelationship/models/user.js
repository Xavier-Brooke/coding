const mongoose = require("mongoose") ;

async function main() {
    await mongoose.connect("mongodb://127.0.0.1:27017/relationships") ;
}

main()
    .then(() => {
        console.log(`Successfully Connected to MongoDB`) ;
    })
    .catch((err) => {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
    })

const userSchema = new mongoose.Schema({
    username : String,
    addresses : [
        {
            _id : false,
            location : String,
            city : String
        }
    ]
})

const User = mongoose.model("User", userSchema) ;

const user1 = new User({
    username : "Catlyn",
    addresses : [
        {
            location : "Wall Street",
            city : "New Delhi"
        },
        {
            location : "Rajapur Pull",
            city : "Patna"
        }
    ]
})

user1.save()
    .then((res) => {
        console.log(res) ;
    })
    .catch((err) => {
        console.error(err)
    })