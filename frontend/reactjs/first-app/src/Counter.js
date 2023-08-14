import { Component } from "react";

class Counter extends Component {
  constructor() {
    super();
    this.state = { count: 0 };
    console.log("inside Counter constructor");
  }
  increment() {
    const updatedCount = this.state.count + 1;
    const newState={ count: updatedCount };
    this.setState(newState);
    console.log("counter is " + this.state.count,"updated count="+updatedCount);
  }

  render() {
    console.log("inside Counter render");
    return (
      <div>
        <h1>Counter Component</h1>
        Count is {this.state.count}
        <button onClick={() => this.increment()}>Increment</button>
      </div>
    );
  }
}

export default Counter;
