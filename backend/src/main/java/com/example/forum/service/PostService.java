package com.example.forum.service;

import java.util.List;
import com.example.forum.dto.Post;
import com.example.forum.models.PostEntity;

public interface PostService {
    List<Post>getAllPost();
    
    Post createPost(Post postEntity);

    Post updatePost(String id,Post post) throws Exception;

    String deletePost(String id) throws Exception;

    Post getPostById(String id) throws Exception;
}