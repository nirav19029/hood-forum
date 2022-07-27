package com.example.forum.repositoryservices.comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.example.forum.dto.Comment;
import com.example.forum.models.CommentEntity;
import com.example.forum.repository.CommentRepository;
import com.mongodb.client.result.DeleteResult;

@Service
public class CommentRepositoryServiceImpl implements CommentRepositoryService{

    private ModelMapper modelMapper;
    
    @Autowired
    CommentRepository commentRepository;

    //Using this to query Mongodb
    @Autowired
    private MongoTemplate mongoTemplate;

    CommentRepositoryServiceImpl(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Comment createComment(Comment comment) {
        CommentEntity commentEntity = modelMapper.map(comment, CommentEntity.class);
        commentRepository.save(commentEntity);
        return comment;
    }

    @Override
    public ArrayList<Comment> getAllComments(String postId) {
        ArrayList<Comment> comments=new ArrayList<>();
        Query query = new Query();            //For the query parameter
        query.addCriteria(Criteria.where("postId").is(postId));  //key- postId, value- Input vaue in postId parameter
        // List<CommentEntity> commentEntity = mongoTemplate.find(query, CommentEntity.class);
        List<CommentEntity> commentEntity = commentRepository.findAll();

        System.out.println("list of comments are"+"/n"+commentEntity);
        for(CommentEntity temp:commentEntity){
            /*Converting the list of entities into Dto and adding it in the dto list*/
            
            comments.add(modelMapper.map(temp, Comment.class));
        }
        return comments;
    }

    @Override
    public Comment getCommentByCommentId(String commentId) throws Exception {
        Optional<CommentEntity> commentEntity = commentRepository.findById(commentId);
      
        if(commentEntity.isPresent()){
            return modelMapper.map(commentEntity.get(), Comment.class);
        }else{
            throw new Exception("Id not present");
        } 
    }
    @Override
    public String deleteByCommentId(String id) throws Exception {
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        if(commentEntity.isPresent()){
            commentRepository.deleteById(id);
            return "Post Deleted";
        }else{
            throw new Exception("Id not present");
        }
    }
    
    @Override
    public String deleteByPostId(String postId) throws Exception {
        Query query = new Query();            //For the query parameter
        query.addCriteria(Criteria.where("postId").is(postId));  //key- postId, value- Input vaue in postId parameter
        DeleteResult commentEntity = mongoTemplate.remove(query, CommentEntity.class);
        if(commentEntity.wasAcknowledged()){
            return "comments on post is deleted";
        }
        else{
            throw new Exception("PostId not present");
        }
       
    }
    
}
