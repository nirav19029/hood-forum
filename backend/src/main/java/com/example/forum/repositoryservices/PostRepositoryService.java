package com.example.forum.repositoryservices;

import java.util.List;
import com.example.forum.models.PostEntity;

public interface PostRepositoryService {

    public List<PostEntity> getAllPost();

    public PostEntity createPost(PostEntity postEntity);

    public PostEntity findById(int id);

    public void delete(PostEntity postEntity) ;
    
}
