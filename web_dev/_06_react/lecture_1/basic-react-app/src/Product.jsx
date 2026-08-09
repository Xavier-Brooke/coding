import './Product.css' ;

let divStyle = {
    backgroundColor : "yellow"
}

let titleStyle = {
    backgroundColor : "pink",
    color : "white"
}

let priceStyle = {
    padding : "20px"
}

function Product({ title, price, feature1, feature2 }) {
    return (
        <div  className="Product" style={divStyle}>
            <h3 style={titleStyle}>{title}</h3>
            <h4 style={priceStyle}>{price}</h4>
            <ol>
                {feature1.map((ele) => <li>ele</li>)}
            </ol>
            <p>{price > 500 && <b>Discount of 5%</b>}</p>
            {/* <h5>feature2 = {feature2.a}</h5> */}
        </div>
    ) ;
}

export default Product ;