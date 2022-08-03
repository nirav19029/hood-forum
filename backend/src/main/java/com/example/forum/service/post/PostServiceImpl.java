package com.example.forum.service.post;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forum.dto.Post;
import com.example.forum.repositoryservices.post.PostRepositoryService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepositoryService postRepositoryService;

    @Override
    public List<Post> getAllPost() {
        return postRepositoryService.getAllPost();
    }

    @Override
    public Post createPost(Post post) throws IOException {
        return postRepositoryService.createPost(post);
    }

    @Override
    public Post updatePost(Map<String, Object> updates,String id) throws IllegalArgumentException{
        try {
            return postRepositoryService.updatePost(updates,id);
        } catch (Exception e) {
            throw (e);
        }   
    }


    @Override
    public String deletePost(String id) throws Exception {
        return postRepositoryService.delete(id);
    }

    @Override
    public Post getPostById(String id) throws Exception {
        try {
            Post post = postRepositoryService.findById(id);
            return post;
        } catch (Exception e) {
            throw (e);
        }
    }

}
