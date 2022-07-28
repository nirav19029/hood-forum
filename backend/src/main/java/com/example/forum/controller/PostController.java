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
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Null;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.forum.dto.UserDetails;
import com.example.forum.dto.Image;
import com.example.forum.dto.Post;
import com.example.forum.exchanges.GetPostResponse;
import com.example.forum.exchanges.PostRequestBody;
import com.example.forum.service.post.ImageUploadService;
import com.example.forum.service.post.PostService;;

@RestController
@RequestMapping(PostController.POST_API_ENDPOINT)
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private ImageUploadService imageUploadService;

	@Autowired
	private ModelMapper modelMapper;

	public static final String POST_API_ENDPOINT = "forum/v1";
	public static final String GET_API = "post/all";
	public static final String GET_API_ID = "post/{id}";
	public static final String POST_API = "createPost";

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
	public ResponseEntity<Post> createPost(@Valid @ModelAttribute PostRequestBody postRequestBody,
			@RequestAttribute(name = "user_details", required = false) UserDetails userDetails) throws IOException {

		// here we have access to user_details set by authorizing service
		// +
		// we have access to req body set by client

		// perfrom validation or opetation such as userId from request is same as
		// provided by user request or something

		// this is dummy data sent through authService
		System.out.println("user_details at post controller" + userDetails);
		Post post = new Post();
		String imageUrl;
		if (postRequestBody.getImage() != null) {
			imageUrl = imageUploadService.save(postRequestBody.getImage());
			post.setImageUrl(imageUrl);
		}
		post.setTitle(postRequestBody.getTitle());
		post.setDescription(postRequestBody.getDescription());
		post.setUserId(postRequestBody.getUserId());
		Post postResponse;
		try {
			postResponse = postService.createPost(post);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

		return new ResponseEntity<Post>(postResponse, HttpStatus.CREATED);
	}

	@PutMapping(GET_API_ID)
	public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody Post post) throws Exception {

		Post postResposne = postService.updatePost(id, post);

		return ResponseEntity.ok().body(postResposne);
	}

	@DeleteMapping(GET_API_ID)
	public ResponseEntity<GetPostResponse> deletePost(@PathVariable(name = "id") String id) throws Exception {
		postService.deletePost(id);
		GetPostResponse getPostResponse = new GetPostResponse();
		return new ResponseEntity<GetPostResponse>(getPostResponse, HttpStatus.OK);
	}

}