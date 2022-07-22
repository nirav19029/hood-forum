import React from "react";
import Fab from "@mui/material/Fab";
import PostAddIcon from "@mui/icons-material/PostAdd";

const AddPostButton = () => {
  return (
    <div>
      <Fab color="primary" aria-label="add">
        <PostAddIcon />
      </Fab>
    </div>
  );
};

export default AddPostButton;
