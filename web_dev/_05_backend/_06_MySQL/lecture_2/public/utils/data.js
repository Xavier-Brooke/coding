const faker = require("./faker") ;

let data = [] ;

for(let i = 0; i < 20; i++) {
    data.push(faker()) ;
}

module.exports = data ;