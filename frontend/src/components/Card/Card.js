import React, { useEffect, useState } from "react";
import Avatar from "@mui/material/Avatar";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import Button from "@mui/material/Button";
import ThumbUpOffAltIcon from "@mui/icons-material/ThumbUpOffAlt";
import CommentOutlinedIcon from "@mui/icons-material/CommentOutlined";
import ShareIcon from "@mui/icons-material/Share";
import ThumbUpAltIcon from '@mui/icons-material/ThumbUpAlt'
import moment from 'moment';

import { Spin, Alert } from 'antd';

import "./Card.css";
import axios from "axios";

const SERVER_ADDRESS = "https://project-brew.herokuapp.com/";
// const SERVER_ADDRESS = "http:/  /192.168.38.197:8080";

const Card = (props) => {

  const [userDetail, setUserDetail] = useState({});
  const [loading, setLoading] = useState(false);
  const [like,setLike] = useState(false);
  const token = localStorage.getItem("token");

  let currentTimestamp = props.value.lastModifiedDate;
  let dateofPost = new Intl.DateTimeFormat('en-US', { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit' }).format(currentTimestamp)

  let user = JSON.parse(localStorage.getItem("user"))

  async function fetchDetails() {
    console.log({ props })
    if (props?.value?.userId) {

      let url = SERVER_ADDRESS + "forum/v1/user/" + props.value.userId;

      try {

        setLoading(true)
        let response = await axios({
          method: "get",
          url: url,
          headers: {
            Authorization: "Bearer " + token,
          }
        })

        let { data } = response;
        console.log(data);
        setUserDetail(data);
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
      } finally {
        setLoading(false)

      }

    }


  }
  //------------------userDetail-----------------------------------------------------
  useEffect(() => {
    console.log(props);
    fetchDetails()

  }, [])

  // useEffect(()=>{
  //   setLike(!like)
  // },[])

  
 async  function handleClick(event) {
  
    
    console.log("oncClick  " + props.value.postId);

    let urls = "https://project-brew.herokuapp.com/forum/v1/post/like";
    let body = {
      likedBy: user.userId,
      likedPost: props.value.postId
    }

    try{

      await axios({
        url:urls,
        method: 'POST',
        headers: {
          Authorization: "Bearer " + token
        },
        data: body,
      })
    }
    catch(error){
      console.log("failed");
      if (error.response) {
        // The request was made and the server responded with a status code
        // that falls out of the range of 2xx
        console.log(error.response.data);
        console.log(error.response.status);
        console.log(error.response.headers);
      } else if (error.request) {
        // The request was made but no response was received
        // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
        // http.ClientRequest in node.js
        console.log(error.request);
      } else {
        // Something happened in setting up the request that triggered an Error
        console.log("Error", error.message);
      }

    }


  }
  console.log("----" ,{props})


  return (

    <div className={"card-container " + props.className} id={props.value.postId} >

      {loading ? (
        <div className="nb-spinner">

          <Spin spinning={loading} size="large"  ></Spin>
        </div>
      ) :

        (
          <div>
            <div onClick={() => props.setActive(props.value.postId)}>
              <div className="container">
                <div className="data" >
                  <Avatar alt="Cindy Baker" src={userDetail.image_url} />
                  <div className="info">
                    <h3>{userDetail.name}</h3>
                    <p>{moment(dateofPost).format('MMMM Do YYYY, h:mm:ss a')}</p>
                  </div>
                </div>
                <div className="follow">
                  <Button variant="outlined">+ Follow</Button>
                  <MoreVertIcon />
                </div>
              </div>

              {/* <div> */}

              <br />

              {/* Content */}
              <div className="card-title">{props.value.description}</div>
              <br />
              {/* No.of likes/response */}
              <div className="updation">
                <div className="like-update">{props.value.likedBy.length} likes</div>
                <div className="comment-update">{props.value.noOfComments} comments</div>
              </div>
            </div>
            {/* Like,comment and share */}

            <div className="container-1">
              <Button variant="" className="like" onClick={handleClick}>
                <ThumbUpAltIcon style={{ marginRight: '1rem' }} />
                {like ? <div>Liked</div> : <div>Like</div>}
              </Button>
              <Button variant="" className="comment" onClick={() => props.setActive(props.value.postId)}>
                <CommentOutlinedIcon id="commentIcon" />
                Comment
              </Button>
              <Button variant="" className="share">
                <ShareIcon id="shareIcon" />
                Share
              </Button>
            </div>
          </div>
        )}

    </div>
  );
};

export default Card;
