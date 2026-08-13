const mongoose = require("mongoose") ;
const Listing = require("../listing") ;
const data = require("./data") ;

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

async function initDB() {
    try {
        await Listing.deleteMany({}) ;
        await Listing.insertMany(data) ;
        console.log(`Data inserted successfully`) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
    }
}

initDB() ;