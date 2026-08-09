function Description({description}) {
    return <p>{description.map((ele) => <span>{ele}</span>)}</p>
}

export default Description ;