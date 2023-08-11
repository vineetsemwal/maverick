import React from "react";

export class UserDetailsComponent extends React.Component {
  render() {
    const element= (
      <div>
        <h1>User Details Component</h1>
        username is kalyan
        <br />
        Age is 21
      </div>
    );
    return element;
  }
}
