const { faker } = require("@faker-js/faker") ;

let subjects = ["DSA", "DAA", "OS", "DE", "COA", "DM", "PPS", "DBMS", "AI", "ML", "UID"] ;

function getData() {
    return {
        name : faker.person.fullName(),
        age : faker.number.int({min:15, max:90}),
        subject : subjects[Math.floor(Math.random() * subjects.length)],
        city : faker.location.city()
    }
}

let data = [] ;

for(let i = 0; i < 100; i++) {
    data.push(getData()) ;
}

module.exports = data ;