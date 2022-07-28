package com.example.forum.repositoryservices;

import java.util.List;

import com.example.forum.dto.Post;


public interface PostRepositoryService {

    public List<Post> getAllPost();

    public Post createPost(Post post);

    public Post findById(String id) throws Exception;

    public String delete(String id) throws Exception;
    
}
