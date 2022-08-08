import React from "react";
import Avatar from "@mui/material/Avatar";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import Button from "@mui/material/Button";
import ThumbUpOffAltIcon from "@mui/icons-material/ThumbUpOffAlt";
import CommentOutlinedIcon from "@mui/icons-material/CommentOutlined";
import ShareIcon from "@mui/icons-material/Share";
import ThumbUpAltIcon from '@mui/icons-material/ThumbUpAlt'

import "./Card.css";

const Card = (e) => {
  // console.log(e);
  const handleClick = event => {
    event.currentTarget.classList.toggle('afterClick');
  }
  return (
    <div className={"card-container " + e.className} id={e.value._id}>
      {/* Userinfo */}
      <div className="container">
        <div className="data" onClick={() => e.setActive(e.value._id)}>
          <Avatar src="/broken-image.jpg" className="avatar-img" />
          <div className="info">
            <h3>{e.value.userName}</h3>
            <p>{e.value.date}</p>
          </div>
        </div>
        <div className="follow">
          <Button variant="outlined">+ Follow</Button>
          <MoreVertIcon />
        </div>
      </div>

      <br />

      {/* Content */}
      <div className="card-title">{e.value.description}</div>
      <br />
      {/* No.of likes/response */}
      <div className="updation">
        <div className="like-update">{e.value.like} likes</div>
        <div className="comment-update">0 comments</div>
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
