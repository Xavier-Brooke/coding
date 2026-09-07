const { faker } = require('@faker-js/faker') ;

function getData() {
    return {
        id : faker.string.uuid(),
        name : faker.person.fullName(),
        msg : faker.lorem.paragraph({min:3, max:5})
    }
}

module.exports = getData ;