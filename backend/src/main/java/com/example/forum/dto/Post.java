//Data transfere object 
//Main Logic
package com.example.forum.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;









@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post{
    private String title;
    @Id
    @JsonIgnore

    
    @JsonProperty("_id")
    private String postId;
    private String userId;
    private String createdOn;
    private String description;

    private ArrayList<Comment> replies ;
}