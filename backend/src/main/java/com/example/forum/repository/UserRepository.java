package com.example.forum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.forum.models.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String>{

    
}
