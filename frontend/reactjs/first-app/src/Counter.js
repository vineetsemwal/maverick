import { Component } from "react";

class Counter extends Component {
  constructor() {
    super();
    this.state = { count: 0 };
    console.log("inside Counter constructor");
  }
  increment() {
    this.setState(oldState=>{
      return {count:oldState.count+1}
    });

  }

  render() {
    console.log("inside Counter render");
    return (
      <div>
        <h1>Counter Component</h1>
        Count is {this.state.count}
        <button onClick={() => {
          this.increment();
          this.increment();
          this.increment();
          
         }}>Increment</button>
      </div>
    );
  }
}

export default Counter;
