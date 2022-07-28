import React from "react";
import "./PostDetail.css";
import Card from "../Card/Card";

const PostDetail = (props) => {
  const data = require("./../../data/post.json");
  console.log(props.active);
  const requirePost = data.filter((value) => value._id === props.active);
  console.log(requirePost);
  return (
    <div className="detail-container">
      <Card value={requirePost[0]} />
    </div>
  );
};

export default PostDetail;
