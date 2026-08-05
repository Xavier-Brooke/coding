class ExpressError extends Error {
    constructor(status, message, hint) {
        super() ;
        this.status = status ;
        this.message = message ;
        this.hint = hint ;
    }
}

module.exports = ExpressError ;