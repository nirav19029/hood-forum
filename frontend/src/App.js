import React from "react";
import "./App.css";
import AddPostButton from "./components/card/AddPostButton";
import Card from "./components/card/Card";
import AddFormModal from "./components/card/AddFormModal";

const App = () => {
  return (
    <div>
      <Card />
      <Card />

      <br />
      <br />
      <AddPostButton />
      <br />
      <br />
      <AddFormModal />
    </div>
  );
};

export default App;
