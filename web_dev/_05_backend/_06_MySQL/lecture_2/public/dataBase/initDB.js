const mysql =  require("mysql2") ;
const util = require("node:util") ;

let data = require("../utils/data") ;

const connections = mysql.createConnection({
    user: "root",
    host: "localhost",
    database: "test",
}) ;

const query = util.promisify(connections.query).bind(connections) ;

async function startDB() {
    try {
        let q = "INSERT INTO user (id, userName, email, msg, password) VALUES ?" ;
        let result = await query(q, [data]) ;
        console.log(result) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
    }
}

startDB() ;