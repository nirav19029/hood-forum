import React from "react";
import Card from "./components/Card/Card";
import AddFormModal from "./components/Modal/AddFormModal";
import Header from "./components/Header/Header";
import "./App.css";

const App = () => {
  let data = require("./data/post.json");
  // console.log(data[0]);

  return (
    <div>
      <Header />

      {data.map((e) => {
        return <Card value={e} key={e._id} />;
      })}
      {/* <Card />

      <br />
      <br />
      <Card />
      <Card />

      <br />
      <br />
      <Card />
      <Card />

      <br /> */}
      <br />
      <div className="modal-wrapper">
        <AddFormModal />
      </div>
    </div>
  );
};

export default App;
