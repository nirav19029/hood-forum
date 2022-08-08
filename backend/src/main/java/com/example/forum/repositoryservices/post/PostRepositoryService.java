package com.example.forum.repositoryservices.post;

import java.util.List;
import java.util.Map;

import com.example.forum.dto.Post;


public interface PostRepositoryService {

    public List<Post> getAllPost();

    public Post createPost(Post post);

    public Post findById(String id) throws Exception;

    public String delete(String id) throws Exception;

    Post updatePost(Map<String, Object> updates,String id) throws IllegalArgumentException;
    
}
