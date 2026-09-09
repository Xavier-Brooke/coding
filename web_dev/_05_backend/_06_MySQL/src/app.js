const mysql = require('mysql2') ;
const path = require('node:path');
const utils = require('node:util') ;
const express = require('express') ;
const { v4 : uuid } = require('uuid') ;
const methodOverride = require('method-override') ;

const connection = mysql.createConnection({
    host : 'localhost',
    user : 'root',
    database : 'temp',
    password : 'w*s#x479z#3*5s'
})

const query = utils.promisify(connection.query).bind(connection) ;

const app = express() ;
const port = 8000 ;

app.use(express.json()) ;
app.use(methodOverride('_method')) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.static(path.join(__dirname, '../public'))) ;

app.set('view engine', 'ejs') ;
app.set('views', path.join(__dirname, '../views')) ;

// root path to show total number of users
app.get('/', async (req, res) => {
    try {
        let q = 'SELECT COUNT(*) FROM users' ;
        let result = await query(q) ;
        const count = result[0]["COUNT(*)"] ;
        return res.render('home.ejs', { count }) ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('errors/somethingWentWrong') ;
    }
})

// all posts
app.get('/chats', async (req, res) => {
    try {
        let q = 'SELECT id, name, email FROM users' ;
        let data = await query(q) ;
        return res.render('chats.ejs', {data}) ;
    } catch(err) {
        console.log(`someting went wrong...`) ;
        console.error(err) ;
        return res.render('errors/somethingWentWrong') ;
    }
})

// new post
app.get('/chats/new', (req, res) => {
    return res.render('new.ejs') ;
})

// collecting data from /chats (post)
app.post('/chats', async (req, res) => {
    try {
        let { name, password, email } = req.body ;
        let id = uuid() ;
        let obj = {name, password, email, id} ;
        if(name && password && email) {
            let q = `INSERT INTO users (name, email, password, id) VALUES (?, ?, ?, ?)` ;
            let result = await query(q, [name, password, email, id]) ;
            console.log(result) ;
            return res.send(obj) ;
        }
        res.render('errors/invalidInput') ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('errors/somethingWentWrong')
    }
})

// details
app.get('/chats/:id/details', async (req, res) => {
    try {
        let { id } = req.params ; 
        if(id) {
            let q = 'SELECT * FROM users WHERE id = ?' ;
            let result = await query(q, [id]) ;
            const userData = result[0] ;
            return res.render('details.ejs', { userData }) ;
        }
        return res.render('errors/somethingWentWrong')
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('errors/somethingWentWrong')
    }
})

// update post
app.get('/chats/:id/edit', async (req, res) => {
    try {
        let { id } = req.params ;
        if(id) {
            let q = 'SELECT * FROM users WHERE id = ?' ;
            let result = await query(q, [ id ]) ;
            let userData = result[0] ;
            return res.render('edit.ejs', { userData }) ;
        }
        return res.render('errors/somethingWentWrong') ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('errors/somethingWentWrong') ;
    }
})

app.patch('/chats/:id', async (req, res) => {
    try {
        let { id } = req.params ;
        let { name, password, email } = req.body ;
        let q = `UPDATE users SET name = ?, password = ?, email = ? WHERE id = ?` ;
        let result = await query(q, [ name, password, email, id ]) ;
        console.log(result) ;
        return res.redirect('/chats') ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('errors/somethingWentWrong') ;
    }
})

// delet post
app.delete('/chats/:id/delete', async (req, res) => {
    try {
        let { id } = req.params ;
        if(id) {
            let q = 'DELETE FROM users WHERE id = ?' ;
            let result = await query(q, [id]) ;
            return res.redirect('/chats') ;
        }
        res.render('errors/invalidInput') ;
    } catch(err) {
        console.log(`Something went wrong...`) ;
        console.error(err) ;
        return res.render('errors/somethingWentWrong')
    }
})

app.get(/.*/, (req, res) => {
    res.send('Page not found') ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})