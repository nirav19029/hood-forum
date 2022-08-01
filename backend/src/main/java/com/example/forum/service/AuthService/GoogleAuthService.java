package com.example.forum.service.AuthService;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.example.forum.dto.GoogleUserDetails;

public interface GoogleAuthService {

    GoogleUserDetails verifyGooogleAccessToken(String token) throws RuntimeException, GeneralSecurityException, IOException ;
    
}
