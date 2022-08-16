import React, { useState } from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import AddAPhotoIcon from "@mui/icons-material/AddAPhoto";
import PostAddIcon from "@mui/icons-material/PostAdd";
import "./AddFormModal.css";
import axios from "axios";

const SERVER_ADDRESS = "https://project-brew.herokuapp.com/" ;

const api = SERVER_ADDRESS + "/forum/v1/createPost";

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

export default function BasicModal({ getAllPosts }) {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [selectedImage, setSelectedImage] = useState(null);

  const user = localStorage.getItem("user");
  const token = localStorage.getItem("token");
  let userId = null;

  if (user) {
    userId = JSON.parse(user).userId;
    // console.log(userId);
  }

  const handleTitleChange = (event) => {
    const inputTopic = event.target.value;
    // console.log(inputTopic);
    setTitle(inputTopic);
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

  const handleSubmit = async (event) => {
    event.preventDefault();

    // let postFormData = new FormData();
    // postFormData.append("title", title);
    // postFormData.append("description", description);
    // postFormData.append("userId", userId);
    let data = new FormData();
    data.append("title", title);
    data.append("userId", userId);
    data.append("description", description);
    if (selectedImage) data.append("image", selectedImage);
    // data.append("", "");

    try {
      let response = await axios({
        method: "post",
        url: api,
        data: data,
        headers: {
          "Content-Type": "multipart/form-data",
          Authorization: "Bearer " + token,
        },
      });

      console.log(response);

      if (response.status === 201 && response.data) {
        handleClose();
        getAllPosts();
        setSelectedImage(null);
      }
    } catch (error) {
      if (error.response) {
        // Request made and server responded
        console.log(error.response.data);
        console.log(error.response.status);
        console.log(error.response.headers);
      } else if (error.request) {
        // The request was made but no response was received
        console.log(error.request);
      } else {
        // Something happened in setting up the request that triggered an Error
        console.log("Error", error.message);
      }
    }
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
              onChange={(e) => handleTitleChange(e)}
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
              onClick={handleSubmit}
            >
              Post
            </Button>
          </div>
        </Box>
      </Modal>
    </div>
  );
}
