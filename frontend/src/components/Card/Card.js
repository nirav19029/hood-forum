import React, { useEffect } from "react";
import Avatar from "@mui/material/Avatar";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import Button from "@mui/material/Button";
import ThumbUpOffAltIcon from "@mui/icons-material/ThumbUpOffAlt";
import CommentOutlinedIcon from "@mui/icons-material/CommentOutlined";
import ShareIcon from "@mui/icons-material/Share";
import axios from "axios";
import "./Card.css";

const Card = () => {
  useEffect(() => {
    let data = require("../../data/post.json");
    console.log(data);
  }, []);

  return (
    <div className="card-container" style={{ marginBottom: "3rem" }}>
      {/* Userinfo */}

      <div className="container">
        <div className="data">
          <Avatar src="/broken-image.jpg" className="img" />
          <div className="info">
            <h3>UserName</h3>
            <p>date</p>
          </div>
        </div>
        <div className="follow">
          <Button variant="outlined">+ Follow</Button>
          <MoreVertIcon />
        </div>
      </div>

      <br />
      <br />

      {/* Content */}
      <div className="content">This is nobroker forum description</div>

      {/* No.of likes/response */}
      <div className="updation">
        <div className="like-update">0 likes</div>
        <div className="comment-update">0 comments</div>
      </div>

      <br />
      <br />
      {/* Like,comment and share */}

      <div className="container-1">
        <Button variant="" className="like">
          <ThumbUpOffAltIcon id="likeIcon" />
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