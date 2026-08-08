const mongoose = require("mongoose") ;
const data = require("../utils/faker") ;

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

const studentSchema = new mongoose.Schema({
    name : String,
    age : Number,
    subject : String,
    city : String,
})

const Student = mongoose.model("Student", studentSchema) ;

// Student.insertMany(data)
//     .then(() => {
//         console.log(`Data inserted`) ;
//     })
//     .catch((err) =>{
//         console.log(err) ;
//     })

module.exports = Student ;