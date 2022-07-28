import React from "react";
import "./PostDetail.css";
import Card from "../Card/Card";

const PostDetail = (props) => {
  const data = require("./../../data/post.json");
  console.log(props.active);
  const requireId = data.filter((value) => value._id === props.active);
  console.log(requireId);
  return (
    <div className="detail-container">
      <Card value={requireId} />
    </div>
  );
};

export default PostDetail;
