package com.revature.repositories;

import java.util.List;

import com.revature.models.Lists;

public interface ListsRepo {

	//CRUD Methods
	
	//Create Methods
	boolean insertList(Lists list);
	
	//Read Methods
	public List<Lists> selectAllLists();
	
	public List<Lists> getListsByMovieId(int movieID);
	
	public List<Lists> getListsByUserId(int userID);
	
	public List<Lists> getLikedByUserId(int userID);
	
	public List<Lists> getListByUserAndMovie(int userID, int movieID);
	
	public List<Lists> getWatchListByUserId(int userID);

	//Update Methods
	boolean updateList(Lists movie);
	
	boolean updateLike(int userID,int movieID);
	
	boolean updateWatchList(int userID,int movieID);
	
	boolean updateRemoveLike(int userID,int movieID);
	
	boolean updateRemoveWatchList(int userID,int movieID);
	
	
	//Delete Methods
	boolean deleteList(Lists movie);

}
