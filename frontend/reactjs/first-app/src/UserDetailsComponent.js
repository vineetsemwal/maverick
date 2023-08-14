import { Component } from "react";

 class UserDetailsComponent extends Component {
 
    constructor(props){
        super(props);
    }


  render() {
  const userObj=this.props.user;
    
    return (
      <div>
        <h1>User Details Component</h1>
        Name is {userObj.name}, age is {userObj.age}
        <br/>
         Department is {this.props.dept}
      </div>
    );
  }
}

export default UserDetailsComponent;