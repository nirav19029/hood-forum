import React, { useEffect, useState } from "react";
import Card from "./components/Card/Card";
import AddFormModal from "./components/Modal/AddFormModal";
import Header from "./components/Header/Header";
import PostDetail from "./components/Detail/PostDetail";
import "./App.css";
import axios from "axios";
import CancelIcon from '@mui/icons-material/Cancel';
// import userContext from "./Contexts/userContext";

let Defaultuser = {
  id: "123",
  name: "nproker"
}

const App = () => {
  // let data = require("./data/post.json");
  const [active, setActive] = useState(""); // set postid of active(clicked) user

  const [posts, setPosts] = useState([]); // all post

  const [activePostData, setActivePostData] = useState({}); // set all post deatil of active user (object)

  const [user, setUser] = useState(Defaultuser) // used context for logged in user







  const getAllPosts = async () => {
    const { data } = await axios.get(
      "http://192.168.5.128:8080/forum/v1/post/all", {
    }            // fetching all posts
    );
    console.log("myData" + data);
    setPosts(data);
  };



  useEffect(() => {
    window.scroll(0, 0);
    getAllPosts();

  }, []);

  //---- function for filtering data of active user-------------------
  useEffect(() => {

    if (active != "") {
      let post = posts.find((post) => {
        if (post.postId == active) {
          return true;
        }
      })
      setActivePostData(post);
    }

  }, [active])  // ActivePostData change wrt to active
  //-------------------------------------------------------------------------
  function closeDetail(){
    
    setActive("");
    return;

  }
  return (

    // <userContext.Provider value={user}>

    <div className="App">
      <Header />

      {active !== "" ? (
        <div className="row">
          <div className="col-8">
            <div>
            <button onClick={closeDetail} className="close" ><CancelIcon /></button>

              {posts.map((post) => {
                return (
                  <div key={post.postId}>
                  <Card value={post} setActive={setActive} />
                </div>
                );
              })}
            </div>
          </div>
          <div className="col-4">
            <PostDetail active={active} postData={activePostData} />
          </div>
        </div>
      ) : (
        <div className="row">
          <div className="col-12">
            <div className="main-data">
              {posts.map((post) => {
                return (
                  <div key={post.postId}>
                    <Card value={post} setActive={setActive} />
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
    // </userContext.Provider>

  );
};

export default App;
