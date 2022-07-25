package com.example.forum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.forum.models.CommentEntity;

public interface CommentRepository extends MongoRepository<CommentEntity,String>{

    
}
