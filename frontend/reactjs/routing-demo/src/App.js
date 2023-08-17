import { Component } from "react";
import "./App.css";
import { BrowserRouter as Router, Link, Routes, Route } from "react-router-dom";
import Home from "./Home";
import Contacts from "./Contacts";
import Products from "./Products";

/*
React.createElement(
  'div',{},
  '<h1>Main Component</h1>');
*/
class App extends Component {
  render() {
    return (
    <div>
<Router>

<Link to="/" >Home</Link>
<br/>
<Link to="/contacts" >Contacts</Link>
<br/>
<Link to="/products" >Products</Link>
<Routes>
  <Route path="/" element={<Home/>}/>
  <Route path="/contacts" element={<Contacts/>}/>
  <Route path="/products" element={<Products/>}/>

</Routes>
</Router>

    </div>

    );
  }
}

export default App;
