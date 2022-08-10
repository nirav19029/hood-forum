package com.example.forum.service.AuthService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.apache.tomcat.util.digester.SystemPropertySource;
import org.springframework.stereotype.Service;

import com.example.forum.dto.GoogleUserDetails;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory ;

@Service
public class GoogleAuthServiceImpl  implements GoogleAuthService{
    private static final String CLIENT_ID = "65516858471-jt2m59irk8sjtnfgodt98o70iqrbtqjo.apps.googleusercontent.com" ;
    private static final String CLIENT_ID_HARSH = "693462110352-tf62k67vg2fokedt87ior7sroecpev7l.apps.googleusercontent.com";
    @Override
   public  GoogleUserDetails  verifyGooogleAccessToken(String token) throws RuntimeException, GeneralSecurityException, IOException{


 
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance())
        .setAudience(Collections.singletonList(CLIENT_ID_HARSH))
        .build();


        try{
            GoogleIdToken idToken = verifier.verify(token);

            if (idToken != null) {
                Payload payload = idToken.getPayload();

                
                String email = payload.getEmail();
                boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
                String name = (String) payload.get("name");
                String pictureUrl = (String) payload.get("picture");
               


                return new GoogleUserDetails(name, email, pictureUrl) ;

    
    
    
                } else {

                   throw new Exception("idToken is null ") ;


                }
        }catch(Exception ex){
            throw new RuntimeException("The token is invalid " +  ex.getMessage()) ;
        }
       
    

   }

   
    
}
