const mysql = require('mysql2') ;
const util = require('node:util') ;
const path = require('node:path') ;
const express = require('express') ;
const { v4 : uuid } = require('uuid') ;

const connection = mysql.createConnection({
    host : 'localhost',
    user : 'root',
    database : 'insta',
    password : '********'
})

const query = util.promisify(connection.query).bind(connection) ;

const app = express() ;

app.use(express.json()) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.static(path.join(__dirname, '../public'))) ;

app.set('view engine', 'ejs') ;
app.set('views', path.join(__dirname, '../views')) ;

// root route
app.get('/', async (req, res) => {
    try {
        let q_users = 'SELECT COUNT(*) FROM users' ;
        let q_posts = 'SELECT COUNT(*) FROM posts' ;
        let res_users = await query(q_users) ;
        let res_posts = await query(q_posts) ;
        const countUsers = res_users[0]['COUNT(*)'] ;
        const countPosts = res_posts[0]['COUNT(*)'] ;
        const count = { usersCount : countUsers, postsCount : countPosts} ;
        return res.render('root.ejs', { count }) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('Errors/someThingWentWrong') ;
    }
})

// users
app.get('/insta', async (req, res) => {
    try {
        let q = 'SELECT * FROM users' ;
        const data = await query(q) ;
        return res.render('users.ejs', { data }) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('Errors/someThingWentWrong') ;
    }
})

// Create User
app.get('/insta/newUser', (req, res) => {
    return res.render('newUser.ejs') ;
})

// data from '/insta/newUser'
app.post('/insta', async (req, res) => {
    try {
        const data = req.body?.users ?? req.body ;
        const { name, age, email, password, city, country } = data ;
        const q = 'INSERT INTO users (user_id, name, age, email, `password`, city, country) VALUES (?, ?, ?, ?, ?, ?, ?)' ;
        const result = await query(q, [uuid(), name, Number(age), email, password, city, country]) ;
        console.log(result) ;
        return res.send('200') ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('Errors/someThingWentWrong') ;
    }
})

// Detials
app.get('/insta/:id/details', async (req, res) => {
    try {
        let { id } = req.params ;
        let q = 'SELECT * FROM users WHERE user_id = ?' ;
        const data = await query(q, [id]) ;
        const user = data[0] ;
        return res.render('details.ejs', { user }) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('Errors/someThingWentWrong') ;
    }
})

// create post
app.get('/insta/:id/newPost', async (req, res) => {
    try {
        let { id } = req.params ;
        let q = 'SELECT name FROM users WHERE user_id = ?' ;
        let result = await query(q, [id]) ;
        let data = result[0]?.name ?? 'Null' ;
        if(data != 'Null') {
            return res.render('newPost.ejs', { data }) ;
        }
        return res.send('User not found') ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('Errors/someThingWentWrong') ;
    }
})

// app.get('/insta/newUser', async (req, res) => {
//     try {

//     } catch(err) {
//         console.log(`Something went wrong...`) ;
//         console.error(err) ;
//         return res.render('Errors/someThingWentWrong') ;
//     }
// })

// app.get('/insta/newUser', async (req, res) => {
//     try {

//     } catch(err) {
//         console.log(`Something went wrong...`) ;
//         console.error(err) ;
//         return res.render('Errors/someThingWentWrong') ;
//     }
// })

// invalid request
app.get(/.*/, (req, res) => {
    res.render('Errors/pageNotFound') ;
})

app.listen(8000, () => {
    console.log(`App is listening at port 8000`) ;
})