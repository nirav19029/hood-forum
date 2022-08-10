package com.example.forum.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.forum.dto.GoogleUserDetails;
import com.example.forum.dto.Post;
import com.example.forum.dto.User;
import com.example.forum.exchanges.PostRequestBody;
import com.example.forum.service.post.ImageUploadService;
import com.example.forum.service.post.PostService;

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
			@RequestAttribute(name = "user_details", required = true) User user) throws Exception {

		if (postRequestBody.getUserId().equals(user.getUserId()) == false) {
			throw new Exception("Unauthorized action! ");
		}

		// this is dummy data sent through authService
		// System.out.println("user_details at post controller" + userDetails);
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

			throw new Exception(e.getMessage());
		}

		return new ResponseEntity<Post>(postResponse, HttpStatus.CREATED);
	}

	@PatchMapping(GET_API_ID)
	public ResponseEntity<Post> partialUpdateGeneric(
			@RequestBody Map<String, Object> updates,
			@PathVariable("id") String id, @RequestAttribute(name = "user_details", required = true) User user)throws Exception {
				if (updates.get("userId").equals(user.getUserId()) == false && (updates.containsKey("description") || updates.containsKey("imageurl"))) {
					throw new Exception("Unauthorized action! ");
				}
		Post postResponse = postService.updatePost(updates, id);
		return ResponseEntity.ok().body(postResponse);
	}

	@DeleteMapping(GET_API_ID)
	public ResponseEntity<String> deletePost(@PathVariable(name = "id") String id) throws Exception {

		return new ResponseEntity<String>(postService.deletePost(id), HttpStatus.OK);
	}

}