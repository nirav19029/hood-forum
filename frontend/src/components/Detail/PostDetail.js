import React, { useEffect, useState } from "react";
import "./PostDetail.css";
import Card from "../Card/Card";
import { Tab } from "@mui/material";
import Chip from '@mui/material/Chip';
import DeleteIcon from '@mui/icons-material/Delete';
import ThumbUpOffAltIcon from '@mui/icons-material/ThumbUpOffAlt';
import Stack from "@mui/material/Stack";

const PostDetail = (props) => {
  const data = require("./../../data/post.json");
  let [comment, setComment] = useState([]); // for viewing comment
  let [curr, setCurrentState] = useState(""); // active state
  ///-------------commentView--------------------------------------
  
  useEffect(() => {
    const requirePost = data.filter((value) => value._id === props.active);
    setCurrentState(requirePost[0])
    let url = "https://jsonplaceholder.typicode.com/comments";
    fetch(url)
      .then((res) => res.json())
      .then((data) => {
        // console.log(data[0]);
        setComment([...data]);

      })

  });
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
    console.info('You clicked the delete icon.');
  };
  //--------------------------------------------------------------

  const handleClick = event => {
    event.currentTarget.classList.toggle('afterClick');
  }

  return (
    <div className="detail-container">
      <Card value={curr} className="custom" />
      <br></br>
      <div id="comments-view">
        {comment.map((comm) => {
          return <div id="singleComment">
            <div className="commentBody">
            
            
            <Stack spacing={1} direction="row">
            <h4>{comm.name}</h4>
            <Chip
              onDelete={()=>handleDelete(comm.id)}
              label="Delete"
              deleteIcon={<DeleteIcon />}
              size="small"
              variant="filled"
            />
             <Chip
              onClick={()=>handleClick}
              label="Like"
              icon={<ThumbUpOffAltIcon />}
              variant="filled"
              size="small"
            />
            </Stack>
            {comm.body}</div>
          </div>
        })
        }
      </div>

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