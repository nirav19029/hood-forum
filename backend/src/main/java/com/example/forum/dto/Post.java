//Data transfere object 
//Main Logic
package com.example.forum.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



// class Like {
//     private String useId;
// }


public class Post{
    private String title;
    @Id
    @JsonIgnore
    @JsonProperty("_id")
    private String postId;
    private String userId;
    private Timestamp createdOn;
    private String description;
    private int like;
    private String upload;

    //No Args
    public Post() {
        super();
    }
    //All args
    public Post(String title,String postId,String userId, Timestamp createdOn,String description,int like,String upload){
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
    public void setCreatedOn(Timestamp createdOn){
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