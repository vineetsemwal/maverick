import { Component } from "react";
import "./App.css";
import UserDetailsComponent from "./UserDetailsComponent";
import Counter2 from "./Counter2";
import Counter1 from "./Counter1";
/*
React.createElement(
  'div',{},
  '<h1>Main Component</h1>');
*/
class App extends Component {
  title = "hello";
  users = [
    { name: "mani", age: 26 },
    { name: "manju", age: 23 },
    { name: "ramesh", age: 24 },
  ];
  giveTitle() {
    return "Welcome";
  }

  render() {
    return (
      <div>
        <h1>Main Title is {this.title} </h1>
        Title is {this.giveTitle()}
        {this.users.map((userArg) => (
          <UserDetailsComponent user={userArg} dept="IT" key={userArg.name} />
        ))}
        <Counter1 />
      </div>
    );
  }
}

export default App;
