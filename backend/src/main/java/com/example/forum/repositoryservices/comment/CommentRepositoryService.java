package com.example.forum.repositoryservices.comment;

import java.util.ArrayList;

import com.example.forum.dto.Comment;

public interface CommentRepositoryService {

    Comment save(Comment comment);

    ArrayList<Comment> getAllComments(String postId);
        
}
