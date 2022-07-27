package com.example.forum.dto;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

class Like {
    private String useId;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @JsonIgnore
    @JsonProperty("_id")
    private String commentId;
    
    private String userId;
    private String postId;
    private String description;
    private String createdOn;
    private Like[] likes  ;
    
}
