function flipCoin() {
    let randNum = Math.floor(Math.random() * 100) + 1 ;
    if(randNum%2 == 0) {
        return "H" ;
    } else {
        return "T" ;
    }
}

module.exports = flipCoin ;