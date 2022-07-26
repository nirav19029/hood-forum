package com.example.forum.service.comment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forum.dto.Comment;
import com.example.forum.repositoryservices.comment.CommentRepositoryService;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepositoryService commentRepositoryService;

    @Override
    public Comment createComment(Comment comment) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp dateTime=new Timestamp(time);

        comment.setTimestamp(dateTime);
        return commentRepositoryService.save(comment);
    }

    @Override
    public ArrayList<Comment> getAllComments(String postId) {
        return commentRepositoryService.getAllComments(postId);
    }
    
}
