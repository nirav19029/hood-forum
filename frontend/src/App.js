import React, { useEffect, useState } from "react";
import Card from "./components/Card/Card";
import AddFormModal from "./components/Modal/AddFormModal";
import Header from "./components/Header/Header";
import PostDetail from "./components/Detail/PostDetail";
import "./App.css";
import axios from "axios";

// import userContext from "./Contexts/userContext";

let Defaultuser = {
  id: "123",
  name: "nproker"
}

const App = () => {
  // let data = require("./data/post.json");
  const [active, setActive] = useState(""); // set postid of active(clicked) user
 
  const [posts, setPosts] = useState([]); // all post
  
  const [activePostData, setActivePostData] = useState({}); // set all deatil of active user

  const [user, setUser] = useState(Defaultuser) // used context for logged in user



  const getAllPosts = async () => {
    const { data } = await axios.get(
      "http://192.168.5.128:8080/forum/v1/post/all"         ,{

      // headers:{
      //   "authorization":"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpbWFnZV91cmwiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQUZkWnVjcFlHQVczZ2RUMXpkck1DQVlsdDhRM3lObkFfWDRyOF9BM1Mya2NQQT1zOTYtYyIsImlzcyI6Imhvb2RGb3J1bSIsIm5hbWUiOiJEaXZ5YW5zaHUgUmFqIiwiZXhwIjoxNjY3OTk1OTkxLCJlbWFpbCI6ImRpdnlhbnNodXJhajUwNTBAZ21haWwuY29tIn0.ZmsFBfq7GFI1Y6B1azvLDfWKRfrdUI325expNjxPkqI"
      // }
      
      }            // fetching all posts
    );
    console.log(data);
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
      console.log("xyz");
      console.log({ post })
      setActivePostData(post);
    }

  }, [active])  // ActivePostData change wrt to active
//-------------------------------------------------------------------------
  return (

    // <userContext.Provider value={user}>

      <div className="App">
        <Header />

        {active !== "" ? (
          <div className="row">
            <div className="col-8">
              <div>
                {posts.map((post) => {
                  return <div key={post.postId}>
                    <Card value={post} setActive={setActive} className="carc classname" />

                  </div>;
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
                {posts.map((e) => {
                  return (
                    <div key={e.postId}> 
                      <Card value={e} setActive={setActive} />
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
