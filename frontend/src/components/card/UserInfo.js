import React from "react";
import "./UserInfo.css";
import Avatar from "@mui/material/Avatar";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import Button from "@mui/material/Button";

const UserInfo = () => {
  return (
    <div className="container">
      <div className="data">
        <Avatar src="/broken-image.jpg" className="img" />
        <div className="info">
          <h3>UserName</h3>
          <p>date</p>
        </div>
      </div>
      <div className="follow">
        <Button variant="outlined">Follow</Button>
        <MoreVertIcon />
      </div>
    </div>
  );
};

export default UserInfo;
