package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.dto.User;
import com.example.forum.service.user.UserService;

@RestController
@RequestMapping(UserController.USER_API_ENDPOINT)
public class UserController {

    @Autowired
    private UserService userService;
    
    public static final String USER_API_ENDPOINT="forum/v1";
	public static final String GET_API="user/{id}";
	public static final String POST_API="createPost";


    @GetMapping(GET_API)
    public User findByUserNameAndProfilePage(@PathVariable(name="id") String userId) throws Exception{
        User user =   userService.findByUserId(userId);
        return user ;
    }
}
