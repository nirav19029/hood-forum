package com.example.forum.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.forum.dto.Image;
import com.example.forum.service.post.ImageUploadService;

@RestController
@RequestMapping(ImageController.POST_API_ENDPOINT)
public class ImageController {
    @Autowired
    private ImageUploadService imageUploadService;

    @Autowired
    private ModelMapper modelMapper;

    public static final String POST_API_ENDPOINT = "forum/v1";
    // public static final String GET_API_ID="post/{id}";
    public static final String POST_IMAGE_API = "addImage/{postid}";

    // @PostMapping(POST_IMAGE_API)
    // public ResponseEntity<Image> addImage(@Valid @RequestParam("image")
    // MultipartFile file,
    // @PathVariable(name = "postid") String postid) throws Exception {
    // Image imageResponse;
    // imageResponse = imageUploadService.save(file);

    // return new ResponseEntity<Image>(imageResponse, HttpStatus.CREATED);
    // }
}
