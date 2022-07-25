package com.example.forum.dto;

import lombok.Data;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @JsonIgnore
    @JsonProperty("_id")
    private String userId;
    private String email;
    private String username;
    private String password;
    private String createdAt;

}
