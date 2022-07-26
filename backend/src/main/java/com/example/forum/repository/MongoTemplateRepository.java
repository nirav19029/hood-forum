package com.example.forum.repository;

import java.util.List;

import com.example.forum.models.CommentEntity;

public interface MongoTemplateRepository {
    List<CommentEntity>getAllComments();
}
