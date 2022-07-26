import React from "react";
import UserInfo from "./UserInfo";
import Utilities from "./Utilities";

const Card = () => {
  return (
    <div className="card-container" style={{ marginBottom: "3rem" }}>
      <div>
        {/* Userinfo */}
        <UserInfo />
        {/* Content */}

        <br />
        <br />

        <div className="content">This is nobroker forum description</div>

        {/* No.of likes/response */}
        <div className="updation">
          <div className="like-update">0 likes</div>
          <div className="comment-update">0 comments</div>
        </div>

        <br />
        <br />
        {/* Like,comment and share */}
        <Utilities />
      </div>
    </div>
  );
};

export default Card;
