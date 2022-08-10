//Data transfere object 
//Main Logic
package com.example.forum.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;







@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"_id","_class"})
public class Post {

    @NotNull
    private String title;
    @Id
    // @JsonIgnore
    // @JsonProperty("_id")
    private String postId;


    private String userId;

    private Date createdDate;

    private Date lastModifiedDate;

    private String description;

    private String imageUrl;
    
    private Set<String> likedBy;
}