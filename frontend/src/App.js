import React, { useState } from "react";
import Card from "./components/Card/Card";
import AddFormModal from "./components/Modal/AddFormModal";
import Header from "./components/Header/Header";
import "./App.css";

const App = () => {
  let data = require("./data/post.json");
  const [active, setActive] = useState(true);
  const [post, setPost] = useState([]);

  // console.log(data[0]);

  return (
    <div className="App">
      <Header />

      {active ? (
        <div className="row">
          <div className="col-8">
            <div className="">
              {data.map((e) => {
                return (
                  <Card value={e} key={e._id.$oid} setActive={setActive} />
                );
              })}
            </div>
          </div>
          <div className="col-4">indi</div>
        </div>
      ) : (
        <div className="row">
          <div className="col-12">
            <div className="main-data">
              {data.map((e) => {
                return (
                  <Card value={e} key={e._id.$oid} setActive={setActive} />
                );
              })}
            </div>
          </div>
        </div>
      )}

      <div className="modal-wrapper">
        <AddFormModal />
      </div>
    </div>
  );
};

export default App;
