import * as React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import AddAPhotoIcon from "@mui/icons-material/AddAPhoto";
import PostAddIcon from "@mui/icons-material/PostAdd";
import "./AddFormModal.css";

const style = {
  position: "relative",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "55%",
  height: "55%",
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
    <div className="main-modal">
      <Button
        onClick={handleOpen}
        variant="contained"
        style={{ height: "4rem", width: "4rem", borderRadius: "50%" }}
      >
        <PostAddIcon />
      </Button>
      <Modal
        open={open}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box className="modal-container" sx={style}>
          <header className="title">Start a new discussion</header>

          <div style={{ fontSize: "120%" }}>
            <label style={{ display: "block" }} for="topic">
              <b>Enter your topic to discuss :</b>
            </label>
            <textarea rows="2" required style={{ width: "100%" }} id="topic" />
          </div>

          <div style={{ fontSize: "120%" }}>
            <label for="description">
              <b>Description :</b>
            </label>
            <textarea
              rows="4"
              required
              style={{
                width: "100%",
              }}
              id="description"
            />
          </div>

          <div>
            <Button variant="contained" component="label">
              <AddAPhotoIcon style={{ marginRight: "10px" }} />
              Add Photo
              <input hidden accept="image/*" multiple type="file" />
            </Button>
          </div>

          <div className="finalButton">
            <Button variant="contained" color="success">
              Post
            </Button>
            <Button
              variant="contained"
              color="error"
              style={{ marginLeft: "1rem" }}
              onClick={handleClose}
            >
              Cancel
            </Button>
          </div>
        </Box>
      </Modal>
    </div>
  );
}
