package com.example.forum.controller;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.inject.Provider;
import javax.print.event.PrintEvent;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.dto.Post;
import com.example.forum.exchanges.GetPostResponse;
import com.example.forum.exchanges.PostRequestBody;
import com.example.forum.service.post.PostService;


@RestController
@RequestMapping(PostController.POST_API_ENDPOINT)
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private ModelMapper modelMapper ;

	public static final String POST_API_ENDPOINT="forum/v1";
	public static final String GET_API="post/all";
	public static final String GET_API_ID="post/{id}";   //here Id is postId of the comments
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
	public ResponseEntity<Post> createPost( @Valid @RequestBody  PostRequestBody postRequestBody) throws IOException{
		// first step is to check the format of postRequestBody
		// then convert to actual post object
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
	public ResponseEntity<String>deletePost(@PathVariable(name = "id") String id) throws Exception{
		return new ResponseEntity<String>(postService.deletePost(id), HttpStatus.OK);
	}

}