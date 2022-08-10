package com.example.forum.Filters;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.forum.dto.GoogleUserDetails;
import com.example.forum.dto.User;
import com.example.forum.service.AuthService.GoogleAuthService;
import com.example.forum.service.user.UserService;
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
    @Autowired
    UserService userService;

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
        //    System.out.println("token --- " + token);
           
            try{
                   GoogleUserDetails userDetails =  jwtManager.validateJwtToken(token) ;
                   User user =  userService.findByUserEmail(userDetails.getEmail()) ;

                   if(user!=null){
                    request.setAttribute("user_details", user );
                   }else{
                    throw new Exception("user not registered with us , please signin first") ;
                   }

                    

                   



            }catch(Exception ex){


                throw new RuntimeException(ex.getMessage()) ;

            }

        }else{
            throw new RuntimeException("Authenticatin token not found or not in correct format");
        }
       

        filterChain.doFilter(request, response);
    }

    @Override
protected boolean shouldNotFilter(HttpServletRequest request)
  throws ServletException {
    String path = request.getRequestURI();
    String method = request.getMethod() ;
    return method.equals("OPTIONS") || "/forum/v1/signin".equals(path);
}
}


 
