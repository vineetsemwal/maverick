import { Component } from "react";
import ChildCounter from "./ChildCounter";

class ParentCounter extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
  }

  incrementHandler=()=> {
    const newState = { count: this.state.count + 1 };
    this.setState(newState);
  }

  render() {
    return (
      <div>
        <h3>Parent Component</h3>
        Count is {this.state.count}
        <br/>
        <ChildCounter increment={this.incrementHandler}/>
      </div>
    );
  }
}

export default ParentCounter;