function handelFormSubmit(event) {
    event.preventDefault() ;
    console.log(`Form was submited`) ;
}

function Form() {
    return (
        <form onSubmit={handelFormSubmit}>
            <input type="text" placeholder="write something"/>
            <button>Submit</button>
        </form>
    )
}

export default Form ;