import { Component } from "react";

class Counter1 extends Component {
  constructor() {
    super();
    this.state = { count: 0 };
    console.log("inside Counter constructor");
  }
  increment() {
    const newState={count:this.state.count+1};
    this.setState(newState);
   
  }

  render() {
    console.log("inside Counter render");
    return (
      <div>
        <h1>Counter Component</h1>
        Count is {this.state.count}
        <button onClick={() =>  this.increment()}
         >Increment</button>
      </div>
    );
  }
}

export default Counter1;
