import React from "react";
import Card from "./components/card/Card";
import AddFormModal from "./components/Modal/AddFormModal";
import Header from "./components/Header/Header";
import "./App.css";

const App = () => {
  return (
    <div>
      <Header />

      <Card />
      <Card />

      <br />
      <br />
      <Card />
      <Card />

      <br />
      <br />
      <Card />
      <Card />

      <br />
      <br />
      <div className="modal-wrapper">
        <AddFormModal />
      </div>
    </div>
  );
};

export default App;
