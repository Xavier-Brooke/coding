let getInfo = require("./faker") ;

let data = [] ;

for(let i = 0; i < 10; i++) {
    data.push(getInfo()) ;
}

module.exports = data ;
