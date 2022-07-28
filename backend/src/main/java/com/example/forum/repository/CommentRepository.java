package com.example.forum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.forum.models.CommentEntity;

@Repository
public interface CommentRepository extends MongoRepository<CommentEntity,String>{

    
}