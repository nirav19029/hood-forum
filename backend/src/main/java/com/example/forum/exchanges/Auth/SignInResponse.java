package com.example.forum.exchanges.Auth;

import com.example.forum.dto.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInResponse {

    private UserDetails user_details ;
    private String jwt_token  ;
    
}
