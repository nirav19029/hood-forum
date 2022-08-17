import React, { useState, useEffect } from "react";
import Card from "./components/Card/Card";
import AddFormModal from "./components/Modal/AddFormModal";
import Header from "./components/Header/Header";
import PostDetail from "./components/Detail/PostDetail";
import "./App.css";
import axios from "axios";

const SERVER_ADDRESS = "https://project-brew.herokuapp.com";

const SIGNIN_ENDPOINT = SERVER_ADDRESS + "/forum/v1/signin?googleIdToken=";

import CancelIcon from '@mui/icons-material/Cancel';
// import userContext from "./Contexts/userContext";

let Defaultuser = {
  id: "123",
  name: "nproker",
};

const App = () => {
  // let data = require("./data/post.json");
  const [user, setUser] = useState("");
  const [loading, setLoading] = useState(false);
  const [active, setActive] = useState(""); // set postid of active(clicked) user
  const [posts, setPosts] = useState([]); // all post

  const token = localStorage.getItem("token");

  useEffect(() => {
    syncToLocalStorage();
  }, []);

  useEffect(() => {
    if (user) {
      document.getElementById("signInDiv").hidden = true;
    } else {
      /* global google */

      window.google?.accounts.id.initialize({
        client_id:
          "693462110352-tf62k67vg2fokedt87ior7sroecpev7l.apps.googleusercontent.com",
        callback: handleCallbackResponse,
      });
      window.google?.accounts.id.renderButton(
        document.getElementById("signInDiv"),
        {
          theme: "outline",
          size: "large",
        }
      );
      document.getElementById("signInDiv").hidden = false;
      window.google?.accounts.id.prompt();
    }
  }, [user]);

  async function signInUser(token) {
    let res = await axios.get(SIGNIN_ENDPOINT + token);
    return res;
  }

  function saveToLocalStorage(key, value) {
    localStorage.setItem(key, value);
  }

  function syncToLocalStorage() {
    let user = localStorage.getItem("user");
    // console.log({ user });
    if (!user) {
      setUser(null);
    } else {
      setUser(user);
    }
  }

  function logout() {
    localStorage.removeItem("user");
    localStorage.removeItem("token");
    syncToLocalStorage();
  }
  async function handleCallbackResponse(response) {
    console.log("Encoded JWT ID token: " + response.credential);
    // req to server
    try {
      console.log("sending reques to server");
      setLoading(true);
      let { data } = await signInUser(response.credential);
      setLoading(false);

      // console.log(serverResponse.data)

      let user = data.user_details;
      let jwtServerToken = data.jwt_token;

      saveToLocalStorage("user", JSON.stringify(user));
      saveToLocalStorage("token", jwtServerToken);

      syncToLocalStorage();
    } catch (error) {
      console.log("failed");
      if (error.response) {
        // The request was made and the server responded with a status code
        // that falls out of the range of 2xx
        console.log(error.response.data);
        console.log(error.response.status);
        console.log(error.response.headers);
      } else if (error.request) {
        // The request was made but no response was received
        // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
        // http.ClientRequest in node.js
        console.log(error.request);
      } else {
        // Something happened in setting up the request that triggered an Error
        console.log("Error", error.message);
      }
    }

    // var userObject = jwt_decode(response.credential);
    // console.log(userObject);
    // setUser(userObject);
    document.getElementById("signInDiv").hidden = true;
  }
  //------Google auth ends------------------------





  const getAllPosts = async () => {
    const url = SERVER_ADDRESS + "/forum/v1/post/all";
    const { data } = await axios({
      method: "get",
      url: url,
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    // console.log(data);
    setPosts(data);
  };



  useEffect(() => {
    window.scroll(0, 0);
    getAllPosts();

  }, []);

  //---- function for filtering data of active user-------------------

  // useEffect(() => {
  //   if (active != "") {
  //     let post = posts.find((post) => {
  //       if (post.postId == active) {
  //         return true;
  //       }
  //     })
  //     setActivePostData(post);
  //   }
  // }, [active]); // ActivePostData change wrt to active


  let activePostData = posts.find((post) => {
    if (post.postId == active) {
      return true;
    }
  })

  console.log({ activePostData, active })


  return (
    <div className="App">
      <div id="signInDiv"></div>

      {user && (
        <div>
          <Header />
          <div>
            <button onClick={logout}>logout</button>
          </div>
          <div style={{ display: "flex" }}>
            <div style={{ width: "100%"}}>
              {posts.map((post) => {
                return (
                  <div key={post.postId}>
                    <Card
                      key={post.postId}
                      value={post}
                      setActive={setActive}
                      className="card classname"
                    />
                  </div>
                );
              })}
            </div>

            {active !== "" ? (
              <div style={{ marginLeft: "10px" , width:"40%"}}>

                <div>
                  <PostDetail key={active} active={active} postData={activePostData} />
                </div>
              </div>
            ) : ""
            }


          </div>


          <div className="modal-wrapper">
            <AddFormModal getAllPosts={getAllPosts} />
          </div>
        </div>
      )}
    </div>
  );
};

export default App;
