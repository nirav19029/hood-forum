import React from "react";
import "./App.css";
import AddPostButton from "./components/card/AddPostButton";
import Card from "./components/card/Card";

const App = () => {
  return (
    <div>
      <Card />
      <Card />

      <br />
      <br />
      <AddPostButton />
    </div>
  );
};

export default App;
