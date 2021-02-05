package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.models.Comment;
import com.revature.models.User;
import com.revature.services.CommentService;

@Controller
@RequestMapping(value = "/comment")
//@CrossOrigin(origins = "http://cinematch.s3-website-us-east-1.amazonaws.com", allowCredentials = "true")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true") //dev
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	//Works in postman using get and params
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/userID")
	public @ResponseBody List<Comment> getCommentByUserID(HttpServletRequest req, @RequestParam("userID") int userID) {
		return this.commentService.getCommentByUserID(userID);
		
	}
	
	//Works in postman using get and params
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/movieID")
	public @ResponseBody List<Comment> getCommentByMovieID(HttpServletRequest req, @RequestParam("movieID") int movieID) {
		return this.commentService.getCommentByMovieID(movieID);
		
	}
	
	//Works in postman using post and JSON
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/insert")
	public void insertComment(HttpServletRequest req, @RequestBody Comment comment) {
		User user = new User();
		user.setId(Integer.parseInt(req.getSession(false).getAttribute("userID").toString()));
		comment.setUser(user);
		this.commentService.insertComment(comment);
	}
	
	
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping(value = "/update")
	public void updateComment(HttpServletRequest req, @RequestParam("id") int id, @RequestParam("comment") String comment) {
		this.commentService.updateComment(id, comment, Integer.parseInt(req.getSession(false).getAttribute("userID").toString()));
	}

	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping(value = "/delete")
	public void deleteComment(HttpServletRequest req, @RequestParam("id") int id) {
		this.commentService.deleteComment(id, Integer.parseInt(req.getSession(false).getAttribute("userID").toString()));
	}

}


