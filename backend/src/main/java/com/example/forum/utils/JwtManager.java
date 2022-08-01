package com.example.forum.utils;
import java.io.Serializable; 
import java.util.Base64; 
import java.util.Date; 
import java.util.HashMap; 
import java.util.Map; 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.forum.dto.GoogleUserDetails;
import com.example.forum.dto.User;

@Component 
public class JwtManager implements Serializable {

   private static final long serialVersionUID = 7008375124389347049L;
    public static final long TOKEN_VALIDITY =  24*60*60*100;  // in seconds
    @Value("${jwt.secret}") 
   private String jwtSecret; 


   public String generateJwtToken(User userDetails) throws Exception {
    


      
         Algorithm algorithm = Algorithm.HMAC256(jwtSecret);

        return  JWT.create()
             .withIssuer("hoodForum")
             .withClaim("email", userDetails.getEmail() )
             .withClaim("name", userDetails.getName() )
             .withClaim("image_url", userDetails.getImage_url() )
             .withClaim("exp", new Date(System.currentTimeMillis() + TOKEN_VALIDITY*1000)) 
             .sign(algorithm);
     
      
   } 
   public GoogleUserDetails validateJwtToken(String token) throws Exception { 

         Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
         JWTVerifier verifier = JWT.require(algorithm)
             .withIssuer("hoodForum")
             .build(); 
         DecodedJWT jwt = verifier.verify(token);

         String name = jwt.getClaim("name").asString() ;
         String email = jwt.getClaim("email").asString() ;
         String image_url = jwt.getClaim("image_url").asString() ;
             
         return new GoogleUserDetails(name, email , image_url) ; 
      
   } 
   public String getEmailFromToken(String token) {
    return token;
     
   } 
}