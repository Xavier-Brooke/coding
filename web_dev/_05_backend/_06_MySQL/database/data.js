const mysql = require('mysql2') ;
const utils = require('node:util') ;
const getData = require('./faker.js') ;

let data = [] ;
for(let i = 0; i < 20; i++) {
    data.push(getData()) ;
}

const connection = mysql.createConnection({
    host : 'localhost',
    database : 'temp',
    user : 'root',
    password : 'w*s#x479z#3*5s'
})

const query = utils.promisify(connection.query).bind(connection) ;

async function main() {
    try {
        let q = `INSERT INTO users (id, name, password, email) VALUES ?` ;
        let result = await query(q, [data]) ;
        console.log(result) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
    }
}

main() ;