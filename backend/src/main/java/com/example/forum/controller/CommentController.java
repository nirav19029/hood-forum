package com.example.forum.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.forum.dto.Comment;
import com.example.forum.exchanges.getCommentResponse;
import com.example.forum.service.comment.CommentService;

@RestController
@RequestMapping(CommentController.COMMENT_API_ENDPOINT)
public class CommentController {
    @Autowired
    private CommentService commentService;
    
    public static final String COMMENT_API_ENDPOINT = "forum/v1";
    public static final String GET_API = "comment/all";
    public static final String GET_API_COMMENTID = "comment/{id}";
    public static final String GET_API_POSTID = "/post/comment/{id}";
    public static final String POST_API = "createComment";

   
    @GetMapping(GET_API_COMMENTID)
	ResponseEntity<Comment> getCommentsByCommentId(@PathVariable(name = "id") String id) throws Exception {
		Comment commentResposne = commentService.getCommentByCommentId(id);
		return ResponseEntity.ok().body(commentResposne);
	}


    @GetMapping(GET_API_POSTID)
	ResponseEntity<ArrayList<Comment>> getCommentsByPostId(@PathVariable(name = "id") String id) throws Exception {
		System.out.println("see");
		ArrayList<Comment> commentResposne = commentService.getAllComments(id);
		return ResponseEntity.ok().body(commentResposne);
	}
    @PostMapping(POST_API)
	public ResponseEntity<Comment> postComment(@RequestBody Comment postRequest){

		Comment commentResponse = commentService.createComment(postRequest);

		return new ResponseEntity<Comment>(commentResponse, HttpStatus.CREATED);
	}
    @DeleteMapping(GET_API_COMMENTID)
	public ResponseEntity<String>deleteCommentbyCommentId(@PathVariable(name = "id") String id) throws Exception{
		return new ResponseEntity<String>(commentService.deleteCommentByCommentId(id) , HttpStatus.OK);
	}

    @DeleteMapping(GET_API_POSTID)
	public ResponseEntity<String>deleteCommentByPostId(@PathVariable(name = "id") String id) throws Exception{

		return new ResponseEntity<String>(commentService.deleteCommentByPostId(id), HttpStatus.OK);
	}

    @PutMapping(GET_API_COMMENTID)
	public ResponseEntity<Comment> updateComments(@PathVariable String id, @RequestBody Comment comment) throws Exception {

		Comment commentResposne = commentService.updateComment(id, comment);

		return ResponseEntity.ok().body(commentResposne);
	}

}
