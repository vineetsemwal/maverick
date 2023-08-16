const { useState } = require("react");

function ConditionalRender2(){
const [flag,setNewState]=useState(true);

const handler=()=>{
    const newState=!flag;
    setNewState(newState);
}

return(

 flag?(
    <div>
<h3>Conditional Render</h3>    
Switch is On 

<button onClick={handler}>Switch Off</button>
</div>
    )
 :(
<div>
<h3>Conditional Render</h3>    
Switch is Off

<button onClick={handler}>Switch On</button>
</div>
 )   
)



}

export default ConditionalRender2;