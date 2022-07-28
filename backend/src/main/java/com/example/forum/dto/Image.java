package com.example.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @NotNull
    private String postid;
    @Id
    @JsonIgnore
    @JsonProperty("_id")
    private String imageid;
    private String name;
    private String path;
}
