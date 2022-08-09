package com.example.forum.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection="comment")
public class CommentEntity {
    
    @Id
    private String commentId;

    private String postId;
    private String userId;

    private String comment;
    @CreatedDate
    private Date timestamp;
    @LastModifiedDate
    private Date updatedOn;

    //NoArgs
    public CommentEntity(){
        super();
    }
    //AllArgs
    public CommentEntity(String commentId, String postId, String userId, String comment,Date timestamp,Date updatedOn){
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