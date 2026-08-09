import './App.css'
import {Para} from './Util.jsx'
// import ProductTab from './ProductTab.jsx' ;
import ProductTab from './activity/producTab.jsx';
import Button from './Button.jsx' ;
import Form from './Form.jsx';

function Greet() {
  return <h1>Hello World</h1>
}

function App() {
  return (
    <div className="container">
      <Form/>
    </div>
  ) ;
}

export default App