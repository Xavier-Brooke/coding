const { faker } = require("@faker-js/faker") ;

function getData() {
    return [
        faker.string.uuid(),
        faker.person.fullName(),
        faker.internet.email(),
        faker.lorem.word(),
        faker.internet.password({ length : 18 })
    ]
}

module.exports = getData ;