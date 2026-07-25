let { faker } = require("@faker-js/faker") ;

function getInfo() {
    return {
        id : faker.string.uuid(),
        name : faker.person.fullName(),
        msg : faker.lorem.paragraph({min:2, max:4}),
        date : faker.date.anytime()
    }
}

module.exports = getInfo ;
