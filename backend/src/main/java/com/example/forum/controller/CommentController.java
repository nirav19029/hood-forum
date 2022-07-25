package com.example.forum.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.dto.Comment;
import com.example.forum.service.comment.CommentService;

@RestController
@RequestMapping(CommentController.COMMENT_API_ENDPOINT)
public class CommentController {

	@Autowired
	private CommentService commentService;

    public static final String COMMENT_API_ENDPOINT="comment/v1";
	public static final String GET_API="comment/{id}";
	public static final String POST_API="createComment";

    @PostMapping(POST_API)
	public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        Comment cmt= commentService.createComment(comment);
		return new ResponseEntity<Comment>(cmt, HttpStatus.CREATED);
	}
	
	@GetMapping(GET_API)
	public ArrayList<Comment> getAllComments(@PathVariable(name="id") String id){
		return commentService.getAllComments(id);
	}
}
