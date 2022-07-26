import React from "react";
import ViewAll from "./ViewAll";
import "./Header.css";

const Header = () => {
  return (
    <div className="header">
      <div id="title">
        <h1>Forum</h1>
      </div>
      <div id="menu">
        <ViewAll />
      </div>
    </div>
  );
};

export default Header;
