package com.example.forum.service.post;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.forum.dto.Post;

public interface PostService {
    List<Post>getAllPost();
    
    Post createPost(Post post) throws IOException;

    Post updatePost(Map<String, Object> updates,String id) throws Exception;

    String deletePost(String id) throws Exception;

    Post getPostById(String id) throws Exception;
}