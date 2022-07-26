package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.service.CommentService;

@RestController
@RequestMapping()
public class CommentController {
    @Autowired
    private CommentService commentService;
    public static final String POST_API_ENDPOINT = "forum/v1";
    public static final String GET_API = "post/all";
    public static final String GET_API_ID = "post/{id}";
       public static final String POST_API = "createPost";

}
