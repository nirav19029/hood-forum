package com.example.forum.dto;

import java.sql.Timestamp;

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

    private Timestamp timestamp;

    //NoArgs
    public Comment(){
        super();
    }
    //AllArgs
    public Comment(String commentId, String postId, String userId, String comment,Timestamp timestamp){
        super();
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
        this.timestamp = timestamp;
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

    public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
