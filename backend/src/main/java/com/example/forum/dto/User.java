package com.example.forum.dto;

import lombok.Data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   
    
    private String userId;
    private String name ;
    private String email;
    private String image_url ;
    
   

}
