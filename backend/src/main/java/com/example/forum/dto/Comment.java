package com.example.forum.dto;

import java.util.Date;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {
    @Id
    @JsonIgnore
    @JsonProperty("_id")
    private String commentId;

    private String postId;
    private String userId;

    private String comment;

    private Date timestamp;

    private Date updatedOn;

    //NoArgs
    public Comment(){
        super();
    }
    //AllArg
    public Comment(String commentId, String postId, String userId, String comment,Date timestamp,Date updatedOn){
        super();
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
        this.timestamp = timestamp;
        this.updatedOn = updatedOn; 
    }

    public String getCommentId(){
        return commentId;
    }

    public void setCommentId(String commentId){
        this.commentId = commentId;
    }

    public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

    public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

    public Date getUpdatedOn(){
        return updatedOn;
    }
    public void setUpdatedOn(Date updatedOn){
        this.updatedOn = updatedOn;
    }
}