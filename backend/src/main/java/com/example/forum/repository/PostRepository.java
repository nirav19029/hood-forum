package com.example.forum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.forum.models.PostEntity;

public interface PostRepository extends MongoRepository<PostEntity,String>{
    
}
