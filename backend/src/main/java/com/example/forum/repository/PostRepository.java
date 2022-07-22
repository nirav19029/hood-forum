package com.example.forum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.forum.models.PostEntity;

// import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends MongoRepository<PostEntity,String>{
    
}
