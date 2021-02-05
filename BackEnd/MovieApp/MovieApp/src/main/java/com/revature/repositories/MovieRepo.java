package com.revature.repositories;

import java.util.List;

import com.revature.models.Movie;

public interface MovieRepo {
	
	//CRUD
	
	//Create
	public boolean insertMovie(Movie movie);
	
	//Read
	public List<Movie> selectAllMovies();
	
	public List<Movie> getMovieByMovieId(int movieID);

}
