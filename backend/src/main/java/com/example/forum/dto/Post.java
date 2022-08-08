//Data transfere object 
//Main Logic
package com.example.forum.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;







@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @NotNull
    private String title;
    @Id
    @JsonIgnore

    private String postId;


    private String userId;

    private Date createdDate;

    private String description;

    private String imageUrl;
    
    private Set<String> likedBy;
}