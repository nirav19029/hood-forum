package com.example.forum.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.forum.dto.Image;
import com.example.forum.models.ImageEntity;

@Repository
public interface ImageRepository extends MongoRepository<ImageEntity, String> {
    ImageEntity findByPostid(String postid);
}
