//Data transfere object 
//Main Logic
package com.example.forum.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

class Like {
    private String useId;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @NotNull
    private String title;

    private String postId;


    private String userId;

    private Date createdDate;

    private String description;

    private String imageUrl;
}