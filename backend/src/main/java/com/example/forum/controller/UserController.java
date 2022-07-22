package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.service.UserService;
import com.example.forum.utils.UserProfile;
import com.example.forum.utils.UserProfileService;

@RestController
@RequestMapping(UserController.USER_API_ENDPOINT)
public class UserController {
    
    public static final String USER_API_ENDPOINT="forum/v1";
	public static final String GET_API="user";
	public static final String POST_API="createPost";

    // @Autowired
    // private UserService userService;

    // @Autowired
    // private UserProfileService userProfileService;

    // @GetMapping(GET_API)
    // public String findByUserNameAndProfilePage(@PathVariable String username,
    // Model model){
    //     UserProfile userProfile;
    //     return "";
    // }
}
