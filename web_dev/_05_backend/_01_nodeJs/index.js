// const process = require('node:process') ;

// const args = process.argv.slice(2) ;
// for(let ele of args) {
//     console.log(`Hello, ${ele}`) ;
// }

const figlet = require('figlet') ;

figlet('Hello World', function(err, res) {
    if(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return ;
    }
    console.log(res) ;
})