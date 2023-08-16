const { useState } = require("react");

function ConditionalRender3() {
  const [flag, setNewState] = useState(true);

  const handler = () => {
    const newState = !flag;
    setNewState(newState);
  };

  return (
    <div>
      <h3>Conditional Render</h3>

      {flag ? <div>Switch is On</div> : <div>Switch is Off</div>}

      <button onClick={handler}>
       
        {flag ? <div>Switch Off</div> : <div>Switch On</div>}
      </button>
    </div>
  );
}

export default ConditionalRender3;
