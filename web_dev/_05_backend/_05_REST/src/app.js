const path = require('node:path') ;
const express = require('express') ;
const { v4 : uuid } = require('uuid') ;
const methodOverride = require('method-override') ;

let data = require('../data/data.js') ;

const app = express() ;
const port = 8080 ;

app.use(express.json()) ;
app.use(methodOverride('_method')) ;
app.use(express.urlencoded({extended:true})) ;
app.use(express.static(path.join(__dirname, '../public/style'))) ;

app.set('view engine', 'ejs') ;
app.set('views', path.join(__dirname, '../views')) ;

// All Chats
app.get('/chats', (req, res) => {
    return res.render('chats.ejs', { users : data }) ;
})

// newChat
app.get('/chats/new', (req, res) => {
    return res.render('newChat.ejs') ;
})

// receiving data from /chats
app.post('/chats', (req, res) => {
    let { name, msg } = req.body ;
    data.push({name, msg, id: uuid()}) ;
    res.redirect('/chats') ;
})

// details
app.get('/chats/:id/details', (req, res) => {
    let { id } = req.params ;
    let user = data.find((ele) => ele.id == id) ;
    if(user) {
        return res.render('details.ejs', { user }) ;
    }

    return res.send('user not found') ;
})

app.get('/chats/:id/edit', (req, res) => {
    let { id } = req.params ;
    let user = data.find((ele) => ele.id == id) ;
    if(user) {
        return res.render('edit.ejs', { user }) ;
    }

    return res.send('user not found') ;
})

app.patch('/chats/:id', (req, res) => {
    let { id } = req.params ;
    let { name, msg } = req.body ;
    data = data.map((ele) => {
        if(ele.id == id) {
            return {
                name, msg
            }
        } else {
            return ele
        }
    })
    res.redirect('/chats') ;
})

app.delete('/chats/:id/delete', (req, res) => {
    let { id } = req.params ;
    data = data.filter((ele) => ele.id != id) ;
    return res.redirect('/chats') ;
})

app.get(/.*/, (req, res) => {
    res.send('Page not found') ;
})

app.listen(port, () => {
    console.log(`App is listening at port :- ${port}`) ;
})