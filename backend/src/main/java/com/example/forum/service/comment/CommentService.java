package com.example.forum.service.comment;

import java.util.ArrayList;

import com.example.forum.dto.Comment;

public interface CommentService {

    ArrayList<Comment> getCommentsByPostId(String postId);

    Comment getCommentByCommentId(String id) throws Exception;

    Comment createComment(Comment postRequest);

    String deleteCommentByCommentId(String id) throws Exception;

    String deleteCommentByPostId(String id) throws Exception;

    Comment updateComment(String id, Comment comment) throws IllegalArgumentException;


}
