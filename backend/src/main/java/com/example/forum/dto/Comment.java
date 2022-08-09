package com.example.forum.dto;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Comment {
    private String commentId;

    @NotNull
    @NotEmpty
    private String postId;
    @NotNull
    @NotEmpty
    private String userId;

    @NotNull
    @NotEmpty
    private String comment;
    
    private Date timestamp;

    private Date updatedOn;

}