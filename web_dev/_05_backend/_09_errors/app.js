const express = require("express") ;
const ExpressError = require("./expressError") ;

const app = express() ;
const port = 3000 ;

app.use("/api", (req, res, next) => {
    let { token } = req.query ;
    if(token == "grant") {
        return next() ;
    } else {
        throw new ExpressError(401, "ACCESS DENIED", "Provide Token") ;
    }
})

app.use("/admin", (req, res, next) => {
    let { password } = req.query ;
    let validPass = password?.toLowerCase() ?? "INVALID" ;
    if((validPass.toLowerCase() !== "invalid") && (validPass === "grant")) {
        return next() ;
    } else {
        throw new ExpressError(401, "INVALID PASSWORD", "ENTER VALID PASSWORD") ;
    }
})

app.get("/", (req, res) => {
    res.send("This is root page") ;
})

app.get("/random", (req, res) => {
    res.send("This is random page") ;
})

app.get("/api", (req, res) => {
    res.send("DATA") ;
})

app.get("/err", (req, res) => {
    try {
        abc = abc ;
    } catch(err) {
        throw new ExpressError(404, err.message, "Define the variable to execute the code") ;
    }
})

app.get("/admin",(req, res) => {
    res.status(200).send("Welcome to admin route") ;
})

app.get(/.*/, (req, res) => {
    res.send("PAGE NOT FOUND!").status(404) ;
})

app.use((err, req, res, next) => {
    console.log("-".repeat(20), `Error handling middleware 1`, "-".repeat(20)) ;
    let { status=401, message="Bad request", hint="Enter valid request" } = err ;
    let code = `<div style="height:200px; width:500px; border:1px solid black; background-color:orange">
                    <h1 style="color:red;">Error Occurred</h1>
                    <h4>Error Status :- ${status}</h4>
                    <h4>Message :- ${message}</h4>
                    <h4>Hint :- ${hint}</h4>
                </div>`
    res.status(status).send(code) ;
})

app.listen(port, () => {
    console.log(`App is listening at port ${port}`) ;
})