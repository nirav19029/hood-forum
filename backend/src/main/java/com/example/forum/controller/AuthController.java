package com.example.forum.controller;



import java.io.IOException;
import java.security.GeneralSecurityException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.dto.User;
import com.example.forum.dto.GoogleUserDetails;
import com.example.forum.exchanges.Auth.SignInResponse;
import com.example.forum.service.AuthService.GoogleAuthService;
import com.example.forum.service.user.UserService;
import com.example.forum.utils.JwtManager;
// import com.example.forum.utils.JwtTokenManager;

@RestController
@RequestMapping(AuthController.AUTH_API_ENDPOINT)
public class AuthController {

    @Autowired
    GoogleAuthService googleAuthService ;

    // @Autowired
    // JwtTokenManager jwtTokenManager ;
    @Autowired
    JwtManager jwtManager ;

    @Autowired 
    UserService userService ;
    
    public static final String AUTH_API_ENDPOINT="forum/v1";
	public static final String SIGNIN_API="signin";
	public static final String POST_API="";


    // will return a token in exchange of a google id token 
    @GetMapping(SIGNIN_API)
    public ResponseEntity<SignInResponse> signIn(@RequestParam String googleIdToken
   ) throws RuntimeException, GeneralSecurityException, IOException , Exception{

       
        //task 1 
        GoogleUserDetails userDetails = googleAuthService.verifyGooogleAccessToken(googleIdToken) ;
 
        
        // check and save

        User user =  userService.findByUserEmail(userDetails.getEmail()) ;

         if(user==null){
            //save
                String email = userDetails.getEmail() ;
                String name = userDetails.getName();
                String image_url = userDetails.getImage_url() ;

            user = new User(null, name,email, image_url) ;
            
            userService.save(user);
         }

        // task 2
        String  jwtToken =  jwtManager.generateJwtToken(user) ;
      


        
        // task 3
        SignInResponse responseBody = new SignInResponse(user,jwtToken ) ;




        return new ResponseEntity<SignInResponse>(responseBody, HttpStatus.OK) ;

    }
}
