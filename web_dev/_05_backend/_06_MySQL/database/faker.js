const { faker } = require('@faker-js/faker') ;

function getData() {
    return [
        faker.string.uuid(),
        faker.person.fullName(),
        faker.internet.password(),
        faker.internet.email()
    ]
}

module.exports = getData ;