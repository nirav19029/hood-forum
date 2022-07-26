package com.example.forum.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.inject.Provider;
import javax.print.event.PrintEvent;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.dto.GoogleAuthUserDetails;
import com.example.forum.dto.Post;
import com.example.forum.exchanges.GetPostResponse;
import com.example.forum.exchanges.PostRequestBody;
import com.example.forum.service.PostService;


@RestController
@RequestMapping(PostController.POST_API_ENDPOINT)
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private ModelMapper modelMapper ;

	public static final String POST_API_ENDPOINT="forum/v1";
	public static final String GET_API="post/all";
	public static final String GET_API_ID="post/{id}";
	public static final String POST_API="createPost";


	@GetMapping(GET_API)
	public List<Post> getAllPosts() {

		return postService.getAllPost();

	}

	@GetMapping(GET_API_ID)
	ResponseEntity<Post> getpostsById(@PathVariable(name = "id") String id) throws Exception {

		Post postResposne = postService.getPostById(id);

		return ResponseEntity.ok().body(postResposne);
	}

	@PostMapping(POST_API)
	public ResponseEntity<Post> createPost( @Valid @RequestBody  PostRequestBody postRequestBody, @RequestAttribute(name = "user_details") GoogleAuthUserDetails googleAuthUserDetails){
		
		// here we have access to user_details set by authorizing service 
		// + 
		// we have access to req body set by client 

		// perfrom validation or opetation such as userId from request is same as provided by user request or something
		


		// this is dummy data sent through authService
		System.out.println("user_details" + googleAuthUserDetails);

		if( googleAuthUserDetails != null){

			System.out.println(googleAuthUserDetails);
		}


		Post post = modelMapper.map(postRequestBody, Post.class) ;

		Post postResponse = postService.createPost(post);

		return new ResponseEntity<Post>(postResponse, HttpStatus.CREATED);
	}

	@PutMapping(GET_API_ID)
	public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody Post post) throws Exception {
		

		Post postResposne = postService.updatePost(id, post);

		return ResponseEntity.ok().body(postResposne);
	}

	@DeleteMapping(GET_API_ID)
	public ResponseEntity<GetPostResponse>deletePost(@PathVariable(name = "id") String id) throws Exception{
		postService.deletePost(id);
		GetPostResponse getPostResponse = new GetPostResponse();
		return new ResponseEntity<GetPostResponse>(getPostResponse, HttpStatus.OK);
	}

}