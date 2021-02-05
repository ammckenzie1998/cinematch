package com.revature.repositories;

import java.util.List;

import com.revature.models.Comment;

public interface CommentRepo {
	
	//CRUD Methods
	
	//Create
	boolean insertComment(Comment comment);
	
	//Read
	public List<Comment> selectAllComments();
	
	//Read
	public List<Comment> getCommentByUserId(int userId);
	
	//Read
	public List<Comment> getCommentByMovieId(int movieId);
	public Comment getCommentById(int id);

	//Update
	boolean updateComment(int id, String comment);
	
	//Delete
	boolean deleteComment(int id);

}
