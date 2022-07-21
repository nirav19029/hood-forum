import * as React from 'react';
import Box from '@mui/material/Box';
import Fab from '@mui/material/Fab';
import AddIcon from '@mui/icons-material/Add';
import EditIcon from '@mui/icons-material/Edit';
import FavoriteIcon from '@mui/icons-material/Favorite';
import NavigationIcon from '@mui/icons-material/Navigation';
import PostAddIcon from '@mui/icons-material/PostAdd';

const addPostButton= () => {
  return (
    <Box sx={{ '& > :not(style)': { m: 1 } }}>
      <Fab color="primary">
        <PostAddIcon />
      </Fab>
    </Box>
  );
}

export default addPostButton;


