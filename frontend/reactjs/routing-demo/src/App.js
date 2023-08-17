import { Component } from "react";
import "./App.css";
import { BrowserRouter as Router, Link, Routes, Route } from "react-router-dom";
import Home from "./Home";
import Contacts from "./Contacts";
import Products from "./Products";
import Navigationbar from "./Navigationbar";

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

<Navigationbar/>
<div className="container" style={{'margin-top':"50px"}}>
  <div className="row">
  <div className="col-md-8" >
<Routes>
  <Route path="/" element={<Home/>}/>
  <Route path="/contacts" element={<Contacts/>}/>
  <Route path="/products" element={<Products/>}/>
</Routes>
</div>
</div>

</div>
</Router>

    </div>

    );
  }
}

export default App;
