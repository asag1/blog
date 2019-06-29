import React from "react";
import "./index.css";

function Button(props) {
  const className = props.secondary ? "Button_secondary" : "Button_primary";

  return (
    <button
      onClick={props.onClick}
      type="button"
      className={`Button ${className}`}
    >
      {props.children}
    </button>
  );
}

export default Button;
