package com.example.forum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.forum.models.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String>{

    
}
