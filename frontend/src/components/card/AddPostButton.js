import * as React from 'react';
import Fab from '@mui/material/Fab';
import AddIcon from '@mui/icons-material/Add';
import PostAddIcon from '@mui/icons-material/PostAdd';

const AddPostButton= () => {
  return (
  <div>
    <Fab color="primary">
        <PostAddIcon />
      </Fab>
      </div>
   
  );
}

export default AddPostButton;


