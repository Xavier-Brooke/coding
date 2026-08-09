import Title from "./title";
import Description from "./description";
import Price from "./price" ;
import './product.css' ;

function Product({title, description, price}) {
    return (
        <div className="Product">
            <Title title={title}/>
            <Description description={description}/>
            <Price price={price}/>
        </div>
    )
}

export default Product ;