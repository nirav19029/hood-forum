package com.example.forum.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommentEntity {
    @Id
    private String commentId;

    private String postId;
    private String userId;

    private String comment;

    private Date timestamp;

    //NoArgs
    public CommentEntity(){
        super();
    }
    //AllArgs
    public CommentEntity(String commentId, String postId, String userId, String comment,Date timestamp){
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

    public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}