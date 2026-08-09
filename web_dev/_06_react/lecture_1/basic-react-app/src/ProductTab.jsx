import Product from './Product.jsx' ;

function ProductTab() {
    return (
        <>
            <Product title="Smart Phone" price={1000} feature1={["Smart", "Phone", "reliable"]}/>
            {/* <Product title="Mac Book" price={2000} feature2={{a: "Smart", b: "Cheap", c: "faru"}}/>
            <Product title="Chrome Book"  price={3000}/> */}
        </>
    ) ; 
}

export default ProductTab ;