package com.example.forum.service.AuthService;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.example.forum.dto.UserDetails;

public interface GoogleAuthService {

    UserDetails verifyGooogleAccessToken(String token) throws RuntimeException, GeneralSecurityException, IOException ;
    
}
