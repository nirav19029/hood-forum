package com.example.forum.utils;

import org.springframework.stereotype.Component;

@Component
public class TokenProcessor {


    public String extractToken(String token_string){


        return token_string.substring(7) ;

    }
    
}
