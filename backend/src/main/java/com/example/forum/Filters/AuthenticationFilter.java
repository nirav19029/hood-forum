package com.example.forum.Filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.forum.dto.GoogleAuthUserDetails;
import com.example.forum.service.AuthService.AuthService;
import com.example.forum.utils.TokenProcessor;




@Component
 public class AuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    TokenProcessor  tokenProcessor;
    @Autowired
    AuthService authService ;

    @Override

    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws
            ServletException, IOException {

        System.out.println(" auth filter in action ");

        final String requestTokenHeader = request.getHeader("Authorization");

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

           String token = tokenProcessor.extractToken(requestTokenHeader) ;
           
            try{
                   GoogleAuthUserDetails userDetails =  authService.verifyGooogleAccessToken(token) ;

                   request.setAttribute("user_details", userDetails);



            }catch(Exception ex){


                throw new RuntimeException(ex.getMessage()) ;

            }

        }
       

        filterChain.doFilter(request, response);
    }



}


 
