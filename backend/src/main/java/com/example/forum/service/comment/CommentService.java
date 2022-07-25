package com.example.forum.service.comment;

import java.util.ArrayList;

import com.example.forum.dto.Comment;

public interface CommentService {

    Comment createComment(Comment comment);

    ArrayList<Comment> getAllComments(String postId);
    
}
