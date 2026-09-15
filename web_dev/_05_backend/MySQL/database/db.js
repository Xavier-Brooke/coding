const mysql = require('mysql2') ;
const util = require('node:util') ;
const getUser = require('./faker.js') ;

let users = [] ;
for(let i = 0; i < 20; i++) {
    users.push(getUser()) ;
}

const connection = mysql.createConnection({
    host : 'localhost',
    user : 'root',
    database : 'insta',
    password : '********'
})

const query = util.promisify(connection.query).bind(connection) ;

async function addUsers() {
    try {
        let q = 'INSERT INTO users VALUES ?' ;
        let ans = await query(q, [users]) ;
        console.log(ans) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.log(err) ;
    }
}

addUsers() ;