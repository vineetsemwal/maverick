import { Component } from "react";
import "./App.css";
import ListProducts from "./components/ListProducts";


class App extends Component {
  render() {
    return (
      <div>
        <ListProducts />
      </div>
    );
  }
}

export default App;
