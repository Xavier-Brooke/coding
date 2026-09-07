const path = require('node:path') ;
const express = require('express') ;

let data = require('../data/data.json') ;

const app = express() ;
const port = 8080 ;

app.use(express.static(path.join(__dirname, '../public'))) ;

app.set('view engine', 'ejs') ;
app.set('views', path.join(__dirname, '../views')) ;

app.get('/api/ig/:user', (req, res) => {
    let { user } = req.params ;
    if(user) {
        let userData = data[user] ;
        if(userData) {
            return res.render('home.ejs', { userData }) ;
        } else {
            return res.send('user not found') ;
        }
    } else {
        return res.send('user not found') ;
    }
})

app.listen(port, () => {
    console.log(`App is listening at ${port}`) ;
})