import React from "react";
//import "./democmp.css"
import democmp1 from "./democmp1.module.css";
import democmp2 from "./democmp2.module.css";

function CssDemo() {
  const styleObj = {
    "background-color": "red",
  };
  return (
    <div>
      <div style={styleObj}>
        <h1>Inline style</h1>
      </div>

      <div className={democmp1.box}>
        <h1>box deign from democp1 css file</h1>
      </div>

      <div className={democmp2.box}>
        <h1>box design from democmp2</h1>
      </div>
    </div>
  );
}

export default CssDemo;
