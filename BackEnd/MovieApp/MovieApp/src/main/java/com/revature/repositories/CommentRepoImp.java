package com.revature.repositories;


import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Comment;
import com.revature.models.User;

@Repository("CommentRepoImp")
@Transactional
public class CommentRepoImp implements CommentRepo {
	
	private SessionFactory sessFact;

	public CommentRepoImp(SessionFactory sessFact) {
		super();
		this.sessFact = sessFact;
	}

	@Override
	public boolean insertComment(Comment comment) {
		sessFact.getCurrentSession().save(comment);
		return true;
	}

	@Override
	public List<Comment> selectAllComments() {
		return sessFact.getCurrentSession().createQuery("from Comment", Comment.class).list();
	}

	@Override
	public Comment getCommentById(int id) {
		return sessFact.getCurrentSession().createQuery("from Comment where id = " + id, Comment.class).getSingleResult();
	}
	
	@Override
	public List<Comment> getCommentByUserId(int userId) {
		return sessFact.getCurrentSession().createQuery("from Comment where user = " + userId + " order by id asc", Comment.class).list();
	}
	
	@Override
	public List<Comment> getCommentByMovieId(int movieId) {
		return sessFact.getCurrentSession().createQuery("from Comment where movieID = " + movieId + " order by id desc", Comment.class).list();
	}

	@Override
	public boolean updateComment(int id, String comment) {
		sessFact.getCurrentSession().createQuery("update Comment set comment = '" + comment + "' where id = " + id).executeUpdate();
		return true;
	}

	@Override
	public boolean deleteComment(int id) {
		sessFact.getCurrentSession().createQuery("delete Comment where id = " + id).executeUpdate();
		return true;
	}
}

