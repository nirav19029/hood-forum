package com.example.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forum.dto.Post;
import com.example.forum.repositoryservices.PostRepositoryService;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepositoryService postRepositoryService;

    @Override
    public List<Post> getAllPost() {
        return postRepositoryService.getAllPost();
    }

    @Override
    public Post createPost(Post post) {
        return postRepositoryService.createPost(post);
    }

    @Override
    public Post updatePost(String id, Post postRequest) throws Exception {
        try {
            Post post = postRepositoryService.findById(id);
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setCreatedOn(postRequest.getCreatedOn());
            return post;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public String deletePost(String id) throws Exception{
        return postRepositoryService.delete(id);
    }

    @Override
    public Post getPostById(String id) throws Exception {
        try {
            Post post = postRepositoryService.findById(id);
            return post;
        } catch (Exception e) {
            throw(e);
        }
    }
    
}
