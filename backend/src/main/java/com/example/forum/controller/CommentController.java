package com.example.forum.controller;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.forum.dto.Comment;
import com.example.forum.dto.User;
import com.example.forum.service.comment.CommentService;

@RestController
@RequestMapping(CommentController.COMMENT_API_ENDPOINT)
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    public static final String COMMENT_API_ENDPOINT = "forum/v1";
    public static final String GET_API_COMMENTID = "comment/{id}";
    public static final String GET_API_POSTID = "/post/comment/{id}";
    public static final String POST_API = "createComment";

	//Get  a Comment by Comment-Id
    @GetMapping(GET_API_COMMENTID)
	ResponseEntity<Comment> getCommentsByCommentId(@PathVariable(name = "id") String id) throws Exception { 
		    //id==CommentId
		// ResponseEntity.ok().body(new Comment());

		Comment commentResposne = commentService.getCommentByCommentId(id);
		return ResponseEntity.ok().body(commentResposne);
	}

	//Get all comments by postId
    @GetMapping(GET_API_POSTID)
	ResponseEntity<ArrayList<Comment>> getCommentsByPostId(@PathVariable(name = "id") String id){	
		
		ArrayList<Comment> commentResposne = commentService.getCommentsByPostId(id);
		return ResponseEntity.ok().body(commentResposne);
	}

	//create comment
    @PostMapping(POST_API)
	public ResponseEntity<Comment> postComment(@Valid @RequestBody Comment commentBody, @RequestAttribute(name = "user_details", required = false) User user) throws Exception{


		if(user.getUserId().equals(commentBody.getUserId())== false){

			 throw new Exception("UnAuthorized , you cannot comment on behalf of" + commentBody.getUserId()) ;
		}
		Comment commentResponse = commentService.createComment(commentBody);

		return new ResponseEntity<Comment>(commentResponse, HttpStatus.CREATED);
	}

	//Delete a comment by comment id
    @DeleteMapping(GET_API_COMMENTID)
	public ResponseEntity<String>deleteCommentbyCommentId(@PathVariable(name = "id") String id) throws Exception{
		return new ResponseEntity<String>(commentService.deleteCommentByCommentId(id) , HttpStatus.OK);
	}

	//Delete all comments by post Id
    @DeleteMapping(GET_API_POSTID)
	public ResponseEntity<String>deleteCommentByPostId(@PathVariable(name = "id") String id) throws Exception{

		return new ResponseEntity<String>(commentService.deleteCommentByPostId(id), HttpStatus.OK);
	}

	//Update a comment
    @PutMapping(GET_API_COMMENTID)
	public ResponseEntity<Comment> updateComments(@PathVariable(name = "id") String id, @RequestBody Comment comment) throws Exception {

		Comment commentResposne = commentService.updateComment(id, comment);

		return ResponseEntity.ok().body(commentResposne);
	}

}
