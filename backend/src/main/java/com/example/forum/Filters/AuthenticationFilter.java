package com.example.forum.Filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.forum.dto.UserDetails;
import com.example.forum.service.AuthService.GoogleAuthService;
import com.example.forum.utils.JwtManager;
import com.example.forum.utils.TokenProcessor;




@Component
@Order(1)
 public class AuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    TokenProcessor  tokenProcessor;
    @Autowired
    GoogleAuthService authService ;

    @Autowired
    JwtManager jwtManager ;

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
           System.out.println("token --- " + token);
           
            try{
                   UserDetails userDetails =  jwtManager.validateJwtToken(token) ;
                    System.out.println("user_details at filter" + userDetails);

                   request.setAttribute("user_details", userDetails);



            }catch(Exception ex){


                throw new RuntimeException(ex.getMessage()) ;

            }

        }
       

        filterChain.doFilter(request, response);
    }

    @Override
protected boolean shouldNotFilter(HttpServletRequest request)
  throws ServletException {
    String path = request.getRequestURI();
    return "/forum/v1/signin".equals(path);
}

}


 
