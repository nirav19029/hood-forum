package com.example.forum.service.AuthService;

import org.springframework.stereotype.Service;

import com.example.forum.dto.GoogleAuthUserDetails;

@Service
public class AuthServiceImpl  implements AuthService{

    @Override
   public  GoogleAuthUserDetails  verifyGooogleAccessToken(String token) throws RuntimeException{

    
        return new GoogleAuthUserDetails("divyansu", "divyanshu.raj@nobroker.in", "http:image.xyz") ;

   }
    
}
