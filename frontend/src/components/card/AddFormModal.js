import * as React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Modal from "@mui/material/Modal";
import IconButton from "@mui/material/IconButton";
import PhotoCamera from "@mui/icons-material/PhotoCamera";
import Stack from "@mui/material/Stack";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "50%",
  height: "50%",
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4,
};

export default function BasicModal() {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <Button onClick={handleOpen}>Open modal</Button>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            <label>Enter your topic to discuss</label>
            <br />
            <input></input>
          </Typography>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            <label>Description</label>
            <br />
            <textarea style={{ width: "100%", height: "50%" }}>
              sadasdfdsfjsdfsod
            </textarea>
          </Typography>
          <Stack direction="row" alignItems="center" spacing={2}>
            <Button variant="contained" component="label">
              Add Photo
              <input hidden accept="image/*" multiple type="file" />
            </Button>
          </Stack>
        </Box>
      </Modal>
    </div>
  );
}
