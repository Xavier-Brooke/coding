import { useState } from "react" ;

function Lottery() {
    
    function randNum() {
        return Math.floor(Math.random() * 900) + 100 ;
    }

    let [ticket, setTicket] = useState(randNum) ;

    function getTicket() {
        setTicket(randNum) ;
    }

    function isValid(num) {
        let ans = false ;
        let sum = 0 ;
        while(num > 0) {
            sum += (num%10) ;
            num = Math.floor(num/10) ;
        }

        ans = (sum == 15) ? true : false ;
        return ans ;
    }
    
    return (
        <div>
            <h3>Lottery {isValid(ticket)? <span>Congratulations, You won!</span> : null}</h3>
            <h6>Lottery Ticket = {ticket}</h6>
            <button onClick={getTicket}>Get new Ticket</button>
        </div>
    )
}

export default Lottery ;