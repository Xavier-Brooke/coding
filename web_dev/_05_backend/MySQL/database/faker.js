const { faker } = require('@faker-js/faker') ;

function users() {
    return [
        faker.string.uuid(),
        faker.person.fullName(),
        Math.floor(Math.random() * 45)+15,
        faker.internet.email(),
        faker.location.city(),
        faker.location.country(),
        faker.internet.password({length:18, memorable:false})
    ]
}

module.exports = users ;