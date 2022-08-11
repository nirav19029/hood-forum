import React, { useEffect, useState } from "react";
import Avatar from "@mui/material/Avatar";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import Button from "@mui/material/Button";
import ThumbUpOffAltIcon from "@mui/icons-material/ThumbUpOffAlt";
import CommentOutlinedIcon from "@mui/icons-material/CommentOutlined";
import ShareIcon from "@mui/icons-material/Share";
import ThumbUpAltIcon from '@mui/icons-material/ThumbUpAlt'
import moment from 'moment';

import "./Card.css";

const Card = (props) => {

  const [userDetail, setUserDetail] = useState ({});
  
  let currentTimestamp = props.value.lastModifiedDate;
  let dateofPost = new Intl.DateTimeFormat('en-US', { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit' }).format(currentTimestamp)


  //------------------userDetail-----------------------------------------------------
  useEffect(() => {
    console.log(props);
    let url = "http://192.168.5.128:8080/forum/v1/user/" + props.value.userId;
    fetch(url)
      .then((response) => response.json())
      .then((data) =>{
        // console.log(data);
        setUserDetail(data)
      });
  },[])
  
  
  const handleClick = event => {
    event.currentTarget.classList.toggle('afterClick');
  }


  return (
    <div className={"card-container " + props.className} id={props.value.postId} onClick={() => props.setActive(props.value.postId)}>
      {/* Userinfo */}
      <div className="container">
        <div className="data" >
        <Avatar alt="Cindy Baker" src={userDetail.image_url} />
          <div className="info">
            <h3>{userDetail.name}</h3>
            <p>{moment(dateofPost).format('MMMM Do YYYY, h:mm:ss a')}</p>
          </div>
        </div>
        <div className="follow">
          <Button variant="outlined">+ Follow</Button>
          <MoreVertIcon />
        </div>
      </div>

      <br />

      {/* Content */}
      <div className="card-title">{props.value.description}</div>
      <br />
      {/* No.of likes/response */}
      <div className="updation">
        <div className="like-update">{props.value.like} likes</div>
        <div className="comment-update">{props.value.noOfComments} comments</div>
      </div>

      {/* Like,comment and share */}

      <div className="container-1">
        <Button variant="" className="like" onClick={handleClick}>
          <ThumbUpAltIcon style={{ marginRight: '1rem' }} />
          Like
        </Button>
        <Button variant="" className="comment">
          <CommentOutlinedIcon id="commentIcon" />
          Comment
        </Button>
        <Button variant="" className="share">
          <ShareIcon id="shareIcon" />
          Share
        </Button>
      </div>
    </div>
  );
};

export default Card;
