package com.example.forum.service.AuthService;

import com.example.forum.dto.GoogleAuthUserDetails;

public interface AuthService {

    GoogleAuthUserDetails verifyGooogleAccessToken(String token) ;
    
}
