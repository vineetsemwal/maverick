import { useState } from "react";

function CounterFunctional(){
 const [currentState,setNewState]=useState(0);  
 //const currentState=array[0];
 //const setNewState=array[1];

 const increment=()=>{
    const newState=currentState+1;
    setNewState(newState);
 }

    return (
        <div>
          <h1>Counter functional Component</h1>
          Count is {currentState}
          <button onClick={increment}>Increment</button>
        </div>
      );
    

}

export default CounterFunctional;