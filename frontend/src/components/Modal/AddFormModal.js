import React, { useState } from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import AddAPhotoIcon from "@mui/icons-material/AddAPhoto";
import PostAddIcon from "@mui/icons-material/PostAdd";
import "./AddFormModal.css";
import axios from "axios";

const api = "http://192.168.5.128:8080/forum/v1/createPost";

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
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const [topic, setTopic] = useState("");
  const [description, setDescription] = useState("");
  const [selectedImage, setSelectedImage] = useState(null);

  const handleTopicChange = (event) => {
    const inputTopic = event.target.value;
    // console.log(inputTopic);
    setTopic(inputTopic);
  };

  const handleDescriptionChange = (event) => {
    const inputDescription = event.target.value;
    // console.log(inputDescription);
    setDescription(inputDescription);
  };

  const handleImgUpload = (event) => {
    // console.log(event.target.files[0]);
    setSelectedImage(event.target.files[0]);
  };

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
            <textarea
              rows="2"
              required
              style={{ width: "100%" }}
              id="topic"
              onChange={(e) => handleTopicChange(e)}
            />
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
              onChange={(e) => handleDescriptionChange(e)}
            />
          </div>

          {/* <div>
            <Button variant="contained" component="label">
              <AddAPhotoIcon style={{ marginRight: "10px" }} />
              Add Photo
              <input hidden accept="image/*" multiple type="file" />
            </Button>
          </div> */}
          {selectedImage && (
            <div>
              <img
                alt="not fount"
                width={"200px"}
                src={URL.createObjectURL(selectedImage)}
              />
              <br />
              <button onClick={() => setSelectedImage(null)}>Remove</button>
            </div>
          )}
          <Button variant="contained" component="label">
            <AddAPhotoIcon style={{ marginRight: "10px" }} />
            Add Photo
            <input
              type="file"
              name="myImage"
              hidden
              accept="image/*"
              multiple
              onChange={(e) => handleImgUpload(e)}
            />
          </Button>

          <div className="finalButton">
            <Button variant="contained" color="error" onClick={handleClose}>
              Cancel
            </Button>

            <Button
              variant="contained"
              color="success"
              style={{ marginLeft: "1rem" }}
            >
              Post
            </Button>
          </div>
        </Box>
      </Modal>
    </div>
  );
}
