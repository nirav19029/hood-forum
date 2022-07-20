package com.example.forum.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.dto.Post;
import com.example.forum.exchanges.getPostResponse;
import com.example.forum.service.postService;


@RestController
@RequestMapping(postController.POST_API_ENDPOINT)
public class postController {

	public static final String POST_API_ENDPOINT="forum/v1";
	public static final String GET_API="post";
	public static final String POST_API="createPost";

	//AutoWire-Service-Layer

	@GetMapping(GET_API)
	ResponseEntity<getPostResponse> getposts() {
		getPostResponse getPostResponse = new getPostResponse();

		//Getting the response from the service layer
		// getPostResponse = postService.(Method name() to find the post with that user Id)

		// List<post>post = getPostResponse.getPost();
		                                                         //Logic

		return ResponseEntity.ok().body(getPostResponse);
	}

	@PostMapping(POST_API)
	public String postPost(){
		return "";
	}

}