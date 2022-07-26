package com.example.forum.service.post;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.forum.dto.Post;

public interface PostService {
    List<Post>getAllPost();
    
<<<<<<< HEAD:backend/src/main/java/com/example/forum/service/PostService.java
    Post createPost(Post post);
=======
    Post createPost(Post post) throws IOException;
>>>>>>> 32d3fa4e90f63404f3ad0c01f39092b0674466f4:backend/src/main/java/com/example/forum/service/post/PostService.java

    Post updatePost(String id,Post post) throws Exception;

    String deletePost(String id) throws Exception;

    Post getPostById(String id) throws Exception;
}