import React, { useEffect, useState,useContext } from "react";
import "./PostDetail.css";
import Card from "../Card/Card";
import { Tab } from "@mui/material";
import Chip from '@mui/material/Chip';
import DeleteIcon from '@mui/icons-material/Delete';
import ThumbUpOffAltIcon from '@mui/icons-material/ThumbUpOffAlt';
import Stack from "@mui/material/Stack";
import CancelIcon from '@mui/icons-material/Cancel';
import { positions } from "@mui/system";
// import userContext from "../../Contexts/userContext";

const PostDetail = (props) => {
  console.log(` props of postdetail ${props.postData.userId}`)
  let [comment, setComment] = useState([]); // for viewing comment
  const [userDetail, setUserDetail] = useState ({});
  // const user = useContext(userContext);
  let user = {
    id: "123",
    name: "nproker"
  }
  
  let loggedInUserId = user.id;



  ///-------------commentView--------------------------------------

  useEffect(() => {
  
    let url = "http://192.168.5.128:8080/forum/v1/post/comment/62e8bd8a3160e9725a0fc7ac";
    fetch(url)
      .then((res) => res.json())
      .then((data) => {
        setComment([...data]);
      })
  },[]);


  //------------------------------------------------------------------------------------

  const postComment = () => {

  }

  //----------------deleting a comment---------------------------
  const handleDelete = (id) => {
    let updateCommentList = comment;
    console.log(updateCommentList.length);
    updateCommentList = updateCommentList.filter((e) => {
      return e.id !== id;
    })
    console.log(updateCommentList.length + "==>final");
    setComment([...updateCommentList])
  };
  //--------------------------------------------------------------

  const handleClick = event => {
    event.currentTarget.classList.toggle('afterClick');
    console.log(setCurrentState);
  }

  return (
    <div className="detail-container">

    
      <Card value={props.postData} className="custom" />
      <br></br>
      
        {comment.length>0 ? (
          <div id="comments-view">
          {comment.map((comm) => {
          return <div id="singleComment">
            <div className="commentBody">

                  {loggedInUserId == props.postData.userId ? (
                    <Stack spacing={1} direction="row">
                  <h4>{comm.name}</h4>
                  <Chip
                    onClick = {() => handleDelete(comm.id)}
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
                  /> </Stack>
                  ) : (
                    <Stack spacing={1} direction="row">
                  <h4>{comm.name}</h4>
                  <Chip
                    onClick={() => handleClick}
                    label="Like"
                    icon={<ThumbUpOffAltIcon />}
                    variant="filled"
                    size="small"
                  /> </Stack>
                  )}
              {comm.comment}</div>
          </div>
        })
        }
        </div>
        ): (<div></div>)}
      

    </div>
  );
};





export default PostDetail;



//   console.log(requirePost);


  // const viewAllComments = () => {
  // let url = "https://jsonplaceholder.typicode.com/comments";
  // fetch(url)
  // .then((res) => res.json())
  // .then((data) => {
  //   let output = "<h2>Comments</h2>";
  //   console.log(data);
  //   data.forEach(element => {
  //     output += `<div>

  //              <p> ${element.body} </p>
  //              </div>
  //              <div style="border:1px solid black"></div>
  //              `;
  //   });
  //   document.getElementById('comments-view').innerHTML = output;
  // })
  // }