const express = require('express') ;
const app = express() ;
const port = 8080 ;

app.get('/', (req, res) => {
    res.send('This is route path') ;
})

app.get('/api', (req, res) => {
    res.send('This is sample api') ;
})

app.get('/api/obj', (req, res) => {
    let obj = {
        name : "Obj",
        city : "Earth-177",
        isValid : false
    }
    return res.send(obj) ;
})

app.get('/api/html', (req, res) => {
    let html = `<h1 style="color:green; text-decoration: underline;">This is sample api</h1>` ;
    res.send(html) ;
})

app.get(/.*/, (req, res) => {
    res.send("Page not found") ;
})

app.listen(port, () => {
    console.log(`App is listening at ${port}`) ;
})