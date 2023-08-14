import { Component } from "react";
import "./App.css";
import UserDetailsComponent from "./UserDetailsComponent";
/*
React.createElement(
  'div',{},
  '<h1>Main Component</h1>');
*/
class App extends Component {
  title = "hello";

   user1={name:"mani", age:26};
   user2={name:"manju", age:23};

  giveTitle() {
    return "Welcome";
  }

  render() {
    return (
      <div>
        <h1>Main Title is {this.title} </h1>
        Title is {this.giveTitle()}

        <UserDetailsComponent user={this.user1} dept="IT" />
        <UserDetailsComponent user={this.user2} dept="HR"/>
      </div>
    );
  }
}

export default App;
