import React from "react";
import Card from "./components/Card/Card";
import AddFormModal from "./components/Modal/AddFormModal";
import Header from "./components/Header/Header";
import "./App.css";

const App = () => {
  let data = require("./data/post.json");
  // console.log(data[0]);

  return (
    <div className="App">
      <Header />
      <div className="main-data">
        {data.map((e) => {
          return <Card value={e} key={e._id} />;
        })}
      </div>

      <div className="modal-wrapper">
        <AddFormModal />
      </div>
    </div>
  );
};

export default App;
