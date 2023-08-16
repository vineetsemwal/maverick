import { Component } from "react";

class ChildCounter extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
}

  render() {
    const incrementHandler = this.props.increment;
    return (
      <div>
        <h3>Child Component</h3>
        <button onClick={() => incrementHandler()}>Increment </button>
      </div>
    );
  }
}
export default ChildCounter;