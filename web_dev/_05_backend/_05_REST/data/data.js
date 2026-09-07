const getData = require('./faker.js') ;

let data = [] ;

for(let i = 0; i < 50; i++) {
    data.push(getData()) ;
}

module.exports = data ;