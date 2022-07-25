package com.example.forum.models;

import java.sql.Timestamp;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


// class Like {
//     private String useId;
// }

@Entity
@Document(collection="post")
public class PostEntity{
    private String title;
    
    @Field("_id")
    private String postId;
    private String userId;
    private Timestamp createdOn;
    private String description;
    private int like;
    private String upload;

    //No Args
    public PostEntity() {
        super();
    }
    //All args
    public PostEntity(String title,String postId,String userId, Timestamp createdOn,String description,int like,String upload){
        super();
        this.postId=postId;
        this.title=title;
        this.userId=userId;
        this.createdOn=createdOn;
        this.description=description;
        this.like=like;
        this.upload=upload;
    }

    //Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    //Post
    public String getPostId() {
        return postId;
    }
    public void setPostId(String postId){
        this.postId=postId;
    }
    //User
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    //createdOn
    public Timestamp getCreatedOn() {
        return createdOn;
    }
    public void setPostId(Timestamp createdOn){
        this.createdOn=createdOn;
    }
    //Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    //Like
    public int getLike(){
        return like;
    }
    public void setLike(int like){
        this.like=like;
    }
    //Upload image string
    public String getUpload(){
        return upload;
    }
    public void setUpload(String upload){
        this.upload=upload;
    }
}
