package com.revature.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Comment;
import com.revature.models.Lists;
import com.revature.repositories.ListsRepo;
import com.revature.repositories.UserRepo;

@Service("ListService")
public class ListsService {
	
	@Autowired
	private ListsRepo listsRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public List<Lists> getListsByUserID(int userID) {
		List<Lists> fetched;
		try {
			fetched = this.listsRepo.getListsByUserId(userID);
			for(Lists l: fetched) {
				l.getUserID().setPassword(null);
			}
		} catch(NoResultException e) {
			fetched = null;
		}
		return fetched;
	}
	
	public List<Lists> getListsByMovieID(int movieID) {
		List<Lists> fetched;
		try {
			fetched = this.listsRepo.getListsByMovieId(movieID);
			for(Lists l: fetched) {
				l.getUserID().setPassword(null);
			}
		} catch(NoResultException e) {
			fetched = null;
		}
		return fetched;
	}
	
	public boolean insertList(Lists list) {
		boolean result;
		result = listsRepo.insertList(list);
		return result;
	}
	
	public List<Lists> getLikedByUserID(int userID) {
		List<Lists> fetched;
		try {
			fetched = this.listsRepo.getLikedByUserId(userID);
			for(Lists l: fetched) {
				l.getUserID().setPassword(null);
			}
		} catch(NoResultException e) {
			fetched = null;
		}
		return fetched;
	}
	
	public List<Lists> getWatchListByUserID(int userID) {
		List<Lists> fetched;
		try {
			fetched = this.listsRepo.getWatchListByUserId(userID);
			for(Lists l: fetched) {
				l.getUserID().setPassword(null);
			}
		} catch(NoResultException e) {
			fetched = null;
		}
		return fetched;
	}
	
	public boolean insertLike(int userID, int movieID) {
		boolean result = false;
		if(userRepo.getUserById(userID) != null) {
			if(listsRepo.getListByUserAndMovie(userID, movieID).isEmpty()) {
				Lists list = new Lists(0, movieID, true, false, userRepo.getUserById(userID));
				result = listsRepo.insertList(list);
			}else {
				result = listsRepo.updateLike(userID, movieID);
			}
		}
		return result;
	}
	
	public boolean removeLike(int userID, int movieID) {
		boolean result;
		result = listsRepo.updateRemoveLike(userID, movieID);
		return result;
	}
	
	public boolean insertWatchList(int userID, int movieID) {
		boolean result = false;
		if(userRepo.getUserById(userID) != null) {
			if(listsRepo.getListByUserAndMovie(userID, movieID).isEmpty()) {
				Lists list = new Lists(0, movieID, false, true, userRepo.getUserById(userID));
				result = listsRepo.insertList(list);
			}else {
				result = listsRepo.updateWatchList(userID, movieID);
			}
		}
		return result;
	}
	
	public boolean removeWatchList(int userID, int movieID) {
		boolean result;
		result = listsRepo.updateRemoveWatchList(userID, movieID);
		return result;
	}
	
	

}
