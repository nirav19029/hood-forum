package com.example.forum.service.comment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.forum.dto.Comment;
import com.example.forum.repositoryservices.comment.CommentRepositoryService;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.example.forum.models.CommentEntity;
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepositoryService commentRepositoryService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Comment createComment(Comment comment) {
        // Date date = new Date();
        // long time = date.getTime();
        // Timestamp dateTime=new Timestamp(time);

        // comment.setTimestamp(dateTime);
        return commentRepositoryService.createComment(comment);
    }

    @Override
    public ArrayList<Comment> getCommentsByPostId(String postId) {
        return commentRepositoryService.getCommentsByPostId(postId);
    }
    
    @Override
    public Comment getCommentByCommentId(String id) throws Exception{
       try {
        Comment comment  = commentRepositoryService.getCommentByCommentId(id);
        return comment;
       } catch (Exception e) {
        throw(e);
       }
    }
    
    @Override
    public String deleteCommentByCommentId(String id) throws Exception{
        try {
            return commentRepositoryService.deleteByCommentId(id);
        } catch (Exception e) {
            throw(e);
        }
    }
    @Override
    public String deleteCommentByPostId(String id) throws Exception{
        try {
            return commentRepositoryService.deleteByPostId(id);
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public Comment updateComment(String id, Comment commentRequest) throws IllegalArgumentException{
        try {
            return commentRepositoryService.updateComment(id,commentRequest);
        } catch (Exception e) {
            throw (e);
        }   
    }

    
}
