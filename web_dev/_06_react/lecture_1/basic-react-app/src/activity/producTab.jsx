import Product from "./product";
import './productTab.css' ;
function ProductTab() {
    return (
        <div className="ProductTab">
            <Product title="Title 1" description={["This is first description", "This is second description"]} price={[112, 234]}/>
            <Product title="Title 2" description={["This is first description", "This is second description"]} price={[112, 234]}/>
            <Product title="Title 3" description={["This is first description", "This is second description"]} price={[112, 234]}/>
            <Product title="Title 4" description={["This is first description", "This is second description"]} price={[112, 234]}/>
        </div>
    )
}

export default ProductTab ;