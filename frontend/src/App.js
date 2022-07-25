import React from "react";
import AddPostButton from "./components/card/AddPostButton";
import Card from "./components/card/Card";
import AddFormModal from "./components/card/AddFormModal";
import Header from "./components/card/Header";
import "./App.css";

const App = () => {
  return (
    <div>
      <Header />

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
