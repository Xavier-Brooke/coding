const mongoose = require("mongoose") ;
const Student = require("./student.js") ;

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

const teacherSchema = new mongoose.Schema({
    name : String,
    age : Number,
    city : String,
    students : [
        {
            type : mongoose.Schema.Types.ObjectId,
            ref : "Student"
        }
    ]
})

const Teacher = mongoose.model("Teacher", teacherSchema) ;

async function addTeacher() {

    let students = await Student.find({subject : "DSA"}) ;

    let res = await Teacher.insertOne({
        name : "Ankit Doyla",
        age : 45,
        city : "New Delhi",
        students : students
    })

    console.log(res) ;
}

// addTeacher() ;

Teacher.findOne({name : "Ankit Doyla"}).populate({path: "Student", match: { subject : "DSA"}})
    .then((res) => {
        console.log(res) ;
    })
    .catch((err) => {
        console.error(err) ;
    })