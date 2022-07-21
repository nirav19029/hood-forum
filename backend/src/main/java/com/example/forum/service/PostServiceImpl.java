package com.example.forum.service;

import java.util.List;
import java.util.Optional;

import javax.el.ELException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forum.dto.Post;
import com.example.forum.models.PostEntity;
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
    public Post createPost(PostEntity postEntity) {
        return postRepositoryService.createPost(postEntity);
    }

    @Override
    public Post updatePost(int id, PostEntity postRequest) {
        try {
            PostEntity postEntity = postRepositoryService.findById(id);
            postEntity.setTitle(postRequest.getTitle());
            postEntity.setDescription(postRequest.getDescription());
            postEntity.setCreatedOn(postRequest.getCreatedOn());
            return postEntity;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public void deletePost(int id) {
        try {
            PostEntity postEntity = postRepositoryService.findById(id);
            postRepositoryService.delete(postEntity);

        } catch (Exception e) {
            throw(e);
        }
        
    }

    @Override
    public PostEntity getPostById(int id) {
        try {
            PostEntity postEntity = postRepositoryService.findById(id);
            return postEntity;

        } catch (Exception e) {
            throw(e);
        }
    }
    
}
