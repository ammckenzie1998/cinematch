package com.revature.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Comment;
import com.revature.repositories.CommentRepo;

@Service("CommentService")
public class CommentService {
	
	@Autowired
	private CommentRepo commentRepo;
	
	public List<Comment> getCommentByUserID(int userID) {
		List<Comment> fetched;
		try {
			fetched = this.commentRepo.getCommentByUserId(userID);
			for(Comment c: fetched) {
				c.getUser().setPassword(null);
			}
		} catch(NoResultException e) {
			fetched = null;
		}
		return fetched;
	}
	
	public List<Comment> getCommentByMovieID(int movieID) {
		List<Comment> fetched;
		try {
			fetched = this.commentRepo.getCommentByMovieId(movieID);
			for(Comment c: fetched) {
				c.getUser().setPassword(null);
			}
		} catch(NoResultException e) {
			fetched = null;
		}
		return fetched;
	}
	
	public boolean insertComment(Comment comment) {
		boolean result;
		result = commentRepo.insertComment(comment);
		return result;
	}

	public boolean updateComment(int id, String comment, int userID) {
		boolean result = false;
		Comment update = commentRepo.getCommentById(id);
		if(update != null && update.getUser().getId() == userID) {
			result = commentRepo.updateComment(id, comment);
		}
		return result;
	}

	public boolean deleteComment(int id, int userID) {
		boolean result = false;
		Comment update = commentRepo.getCommentById(id);
		if(update != null && update.getUser().getId() == userID) {
			result = commentRepo.deleteComment(id);
		}
		return result;
	}

}

