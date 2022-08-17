import React, { useEffect, useState, useContext } from "react";
import "./PostDetail.css";
import Card from "../Card/Card";
import { Tab } from "@mui/material";
import Chip from "@mui/material/Chip";
import DeleteIcon from "@mui/icons-material/Delete";
import ThumbUpOffAltIcon from "@mui/icons-material/ThumbUpOffAlt";
import Stack from "@mui/material/Stack";
import CancelIcon from '@mui/icons-material/Cancel';
import { positions } from "@mui/system";
// import userContext from "../../Contexts/userContext";


const SERVER_ADDRESS = "https://project-brew.herokuapp.com/" ;

const PostDetail = (props) => {
  let [comment, setComment] = useState([]); // for viewing comment
  const [userDetail, setUserDetail] = useState ({});
  // const user = useContext(userContext);

  console.log(props)


  let user = localStorage.getItem("user")


  let loggedInUserId = user.id;

  ///-------------commentView--------------------------------------

  useEffect(() => {
    // let url =
    // SERVER_ADDRESS + "/forum/v1/post/comment/62e8bd8a3160e9725a0fc7ac";
    // fetch(url)
    //   .then((res) => res.json())
    //   .then((data) => {
    //     setComment([...data]);
    //   });
  }, []);
  //------------------------------------------------------------------------------------

  const postComment = () => {};

  //----------------deleting a comment---------------------------
  const handleDelete = (id) => {
    let updateCommentList = comment;
    console.log(updateCommentList.length);
    updateCommentList = updateCommentList.filter((e) => {
      return e.id !== id;
    });
    console.log(updateCommentList.length + "==>final");
    setComment([...updateCommentList]);
    console.info("You clicked the delete icon.");
    console.log(props + "props.active");
  };
  //--------------------------------------------------------------

  const handleClick = (event) => {
    event.currentTarget.classList.toggle("afterClick");
    console.log(setCurrentState);
  };

  return (
    <div className="detail-container">

    
      <Card value={props.postData} className="custom" />
      <br></br>
      {/* <div
      style={{
        marginLeft: "40%",
      }}
    >
      <h2>How to use TextField Component in ReactJS?</h2>
      <TextField
        value={name}
        label="Enter your name"
        onChange={(e) => {
          setName(e.target.value);
        }}
      />
      <h3>Your Enter Value is: {name} </h3>
    </div> */}
      {comment.length > 0 ? (
        <div id="comments-view">
          {comment.map((comm) => {
            return (
              <div id="singleComment">
                <div className="commentBody">
                  {loggedInUserId == props.postData.userId ? (
                    <Stack spacing={1} direction="row">
                      <h4>{comm.name}</h4>
                      <Chip
                        onClick={() => handleDelete(comm.id)}
                        onDelete={() => handleDelete(comm.id)}
                        label="Delete"
                        deleteIcon={<DeleteIcon />}
                        size="small"
                        variant="filled"
                      />
                      <Chip
                        onClick={() => handleClick}
                        label="Like"
                        icon={<ThumbUpOffAltIcon />}
                        variant="filled"
                        size="small"
                      />{" "}
                    </Stack>
                  ) : (
                    <Stack spacing={1} direction="row">
                      <h4>{comm.name}</h4>
                      <Chip
                        onClick={() => handleClick}
                        label="Like"
                        icon={<ThumbUpOffAltIcon />}
                        variant="filled"
                        size="small"
                      />{" "}
                    </Stack>
                  )}
                  {comm.body}
                </div>
              </div>
            );
          })}
        </div>
      ) : (
        <div></div>
      )}
    </div>
  );
};

export default PostDetail;
