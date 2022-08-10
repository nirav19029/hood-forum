import React, { useState } from "react";
import Card from "./components/Card/Card";
import AddFormModal from "./components/Modal/AddFormModal";
import Header from "./components/Header/Header";
import PostDetail from "./components/Detail/PostDetail";
import "./App.css";

const App = () => {
  let data = require("./data/post.json");
  const [active, setActive] = useState("");
  const [post, setPost] = useState([]);
  const [current, setCurrent] = useState(null);

  return (
    <div className="App">
      <Header />

      {active !== "" ? (
        <div className="row">
          <div className="col-8">
            <div>
              {data.map((e) => {
                return <div>
                <Card value={e} key={e._id} setActive={setActive} />
                
                </div>;
              })}
            </div>
          </div>
          <div className="col-4">
            <PostDetail active={active} />
          
          </div>
        </div>
      ) : (
        <div className="row">
          <div className="col-12">
            <div className="main-data">
              {data.map((e) => {
                return (
                 <div> <Card value={e} key={e._id.$oid} setActive={setActive} />
                 
                 
                 </div>
          
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
