
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

import com.example.forum.dto.GoogleUserDetails;
import com.example.forum.dto.Post;
import com.example.forum.exchanges.GetPostResponse;
import com.example.forum.exchanges.PostRequestBody;
import com.example.forum.service.post.ImageUploadService;
import com.example.forum.service.post.PostService;;

@RestController
@RequestMapping(MongoTriggerController.TRIGGER_API_ENDPOINT)
public class MongoTriggerController {



	public static final String TRIGGER_API_ENDPOINT = "forum/v1";
	public static final String POST_API = "/mongoTrigger";
	

	

	@PostMapping(POST_API)
	public  String handleMongoTrigger(@RequestBody Object obj) {

		
		return "mongo trigger hit" ;

	}

	

}