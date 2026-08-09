import { useState } from "react"; 

function LudoBoard() {
    let [moves, setMoves] = useState({blue:0, red:0, yellow:0, green:0}) ;
    let [arr, setArr] = useState(["no moves"]) ;

    function updateBlue() {
        setMoves((prevMoves) => 
        {
            return {...prevMoves, blue: prevMoves.blue+1} ;
        })
        console.log(arr) ;
        setArr((prevArr) => {
            return [...prevArr, "blue move"] ;
        })
    }

    function updateGreen() {
        setMoves((prevMoves) => {
            return {...prevMoves, green: prevMoves.green+1} ;
        })
    }

    return (
        <div>
            <p>Game Begins</p>
            <br/>
            <br/>
            <div>{arr.map((ele) => <span>{ele}&nbsp;</span>)}</div>
            <div className="Board">
                <p>Blue Moves :- {moves.blue}</p>
                <button style={{backgroundColor : "blue"}} onClick={updateBlue}>+1</button>
                <br/>
                <br/>
                <p>red Moves :- {moves.red}</p>
                <button style={{backgroundColor : "red"}}>+1</button>
                <br/>
                <br/>
                <p>yellow Moves :- {moves.yellow}</p>
                <button style={{backgroundColor : "yellow"}}>+1</button>
                <br/>
                <br/>
                <p>green Moves :- {moves.green}</p>
                <button style={{backgroundColor : "green"}} onClick={updateGreen}>+1</button>
                <br/>
                <br/>
            </div>
        </div>
    )
}

export default LudoBoard ;