import { useContext } from "react";
import { UserConsumer } from "./UserContext";

function ContextDemo(){
const user =useContext(UserConsumer);

  return (
  
  <div>
  
    <h3>Context demo</h3>
    <div>name is {user.name}, age is {user.age}</div>
    </div>);

}

export default ContextDemo;