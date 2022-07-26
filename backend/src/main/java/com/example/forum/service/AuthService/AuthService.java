package com.example.forum.service.AuthService;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.example.forum.dto.GoogleAuthUserDetails;

public interface AuthService {

    GoogleAuthUserDetails verifyGooogleAccessToken(String token) throws RuntimeException, GeneralSecurityException, IOException ;
    
}
