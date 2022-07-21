package com.example.forum.service;

import java.util.List;
import com.example.forum.dto.Post;
import com.example.forum.models.PostEntity;

public interface PostService {
    List<PostEntity>getAllPost();
    
    PostEntity createPost(PostEntity postEntity);

    PostEntity updatePost(int id,PostEntity postEntity);

    void deletePost(int id);

    PostEntity getPostById(int id);

    
}