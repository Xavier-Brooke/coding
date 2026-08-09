function printHello() {
    console.log(`Hello`) ;
}

function printBye() {
    console.log(`Bye`) ;
}

function Button() {
    return (
        <div>
            <button onClick={printHello}>Click me!</button>
            <p onMouseEnter={printBye}>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aperiam nobis placeat earum, quia nihil distinctio quasi sequi numquam perspiciatis ipsum maiores sint unde. Temporibus delectus quam deleniti eum nobis incidunt.</p>
        </div>
    ) ;
}

export default Button ;