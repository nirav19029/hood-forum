package com.example.forum.repositoryservices.comment;

import java.util.ArrayList;
import java.util.List;

import com.example.forum.dto.Comment;

public interface CommentRepositoryService {

    Comment createComment(Comment comment);

    ArrayList<Comment> getCommentsByPostId(String postId);

    Comment getCommentByCommentId(String id) throws Exception;

    String deleteByCommentId(String id) throws Exception;

    String deleteByPostId(String id) throws Exception;
        
}
