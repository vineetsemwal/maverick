import { Component } from "react";

class Counter1 extends Component {
  
  constructor() {
    super();
    this.state = { count: 0 };//initial state
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
/**
 * when component inserted in dom
 */
  componentDidMount(){
    console.log("inside component did mount");
  }
  
  shouldComponentUpdate(props, state){
    console.log("inside shouldComponentUpdate", state);
     const change=state.count!=this.state.count;
     console.log("change",change);
     return change;  
  }


}

export default Counter1;
