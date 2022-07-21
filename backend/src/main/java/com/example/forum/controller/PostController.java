package com.example.forum.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.forum.models.PostEntity;
import com.example.forum.service.PostService;


@RestController
@RequestMapping(PostController.POST_API_ENDPOINT)
public class PostController {

	@Autowired
	private ModelMapper modelMapper;

	private PostService postService;

	public static final String POST_API_ENDPOINT="forum/v1";
	public static final String GET_API="post/all";
	public static final String GET_API_ID="post/{id}";
	public static final String POST_API="createPost";

	//AutoWire-Service-Layer

	//Getting all post
	@GetMapping(GET_API)
	public List<Post> getAllPosts() {
		/*Calling the get ALLPost method and appling the 
		modle mapper for each and evey postEntity using arrow function*/
		return postService.getAllPost().stream().map(postEntity -> modelMapper.map(postEntity, Post.class))
		.collect(Collectors.toList());
	}

	@GetMapping(GET_API_ID)
	ResponseEntity<Post> getpostsById(@PathVariable(name = "id") int id) {

		//Convert DTO to Entity
		PostEntity postEntity = postService.getPostById(id);

		// convert entity to DTO
		Post getPostResponse = modelMapper.map(postEntity, Post.class);
		return ResponseEntity.ok().body(getPostResponse);
	}

	@PostMapping(POST_API)
	public ResponseEntity<Post> postPost(@RequestBody Post post){

		//Converting DTO to entity
		PostEntity postRequest = modelMapper.map(post, PostEntity.class);

		PostEntity postEntity = postService.createPost(postRequest);

		//Converting entity to DTO
		Post postResponse = modelMapper.map(postEntity, Post.class);
		return new ResponseEntity<Post>(postResponse, HttpStatus.CREATED);
	}

	@PutMapping(GET_API_ID)
	public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {

		// convert DTO to Entity
		PostEntity postRequest = modelMapper.map(post, PostEntity.class);

		PostEntity postEntity = postService.updatePost(id, postRequest);

		// entity to DTO
		Post postResponse = modelMapper.map(postEntity, Post.class);

		return ResponseEntity.ok().body(postResponse);
	}

	@DeleteMapping(GET_API_ID)
	public ResponseEntity<GetPostResponse>deletePost(@PathVariable(name = "id") int id){
		postService.deletePost(id);
		GetPostResponse getPostResponse = new GetPostResponse();
		return new ResponseEntity<GetPostResponse>(getPostResponse, HttpStatus.OK);
	}

}