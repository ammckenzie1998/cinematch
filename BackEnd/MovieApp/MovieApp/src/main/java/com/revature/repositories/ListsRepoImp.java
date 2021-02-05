package com.revature.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Lists;

@Repository("ListsRepoImp")
@Transactional
public class ListsRepoImp implements ListsRepo {

	private SessionFactory sessFact;
	
	
	public ListsRepoImp(SessionFactory sessFact) {
		super();
		this.sessFact = sessFact;
	}

	@Override
	public boolean insertList(Lists list) {
		sessFact.getCurrentSession().save(list);
		return true;
	}

	@Override
	public List<Lists> selectAllLists() {
		return sessFact.getCurrentSession().createQuery("from Lists", Lists.class).list();
	}

	@Override
	public List<Lists> getListsByMovieId(int movieId) {
		return sessFact.getCurrentSession().createQuery("from Lists where movieID = " + movieId, Lists.class).list();
	}

	@Override
	public List<Lists> getListsByUserId(int userId) {
		return sessFact.getCurrentSession().createQuery("from Lists where user = " + userId, Lists.class).list();
	}

	@Override
	public boolean updateList(Lists list) {
		sessFact.getCurrentSession().update(list);
		return true;
	}

	@Override
	public boolean deleteList(Lists list) {
		sessFact.getCurrentSession().delete(list);
		return true;
	}

	@Override
	public List<Lists> getLikedByUserId(int userId) {
		return sessFact.getCurrentSession().createQuery("from Lists where user = " + userId + "and movieLike = true", Lists.class).list();
	}

	@Override
	public List<Lists> getWatchListByUserId(int userId) {
		return sessFact.getCurrentSession().createQuery("from Lists where user = " + userId + "and movieWatchList = true", Lists.class).list();
	}

	@Override
	public List<Lists> getListByUserAndMovie(int userID, int movieID) {
		return sessFact.getCurrentSession().createQuery("from Lists where user = " + userID + "and movieID = "+ movieID, Lists.class).list();
	}

	@Override
	public boolean updateLike(int userID, int movieID) {
		sessFact.getCurrentSession().createQuery("update Lists set movieLike = true where user = " + userID + "and movieID = " + movieID).executeUpdate();
		return true;
	}

	
	@Override
	public boolean updateWatchList(int userID, int movieID) {
		sessFact.getCurrentSession().createQuery("update Lists set movieWatchList = true where user = " + userID + "and movieID = " + movieID).executeUpdate();
		return true;
	}

	@Override
	public boolean updateRemoveLike(int userID, int movieID) {
		sessFact.getCurrentSession().createQuery("update Lists set movieLike = false where user = " + userID + "and movieID = " + movieID).executeUpdate();
		return true;
	}

	@Override
	public boolean updateRemoveWatchList(int userID, int movieID) {
		sessFact.getCurrentSession().createQuery("update Lists set movieWatchList = false where user = " + userID + "and movieID = " + movieID).executeUpdate();
		return true;
	}

}
