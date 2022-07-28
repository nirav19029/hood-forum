package com.example.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetails {

    private String name ;
    private String email ;
    private String image_url ;

    
}
