package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.models.Movie;
import com.revature.services.MovieService;

@Controller
@RequestMapping(value = "/movie")
//@CrossOrigin(origins = "http://cinematch.s3-website-us-east-1.amazonaws.com", allowCredentials = "true")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true") //dev
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/ID")
	public @ResponseBody List<Movie> getMovieByMovieID(HttpServletRequest req, @RequestParam("movieID") int movieID) {
		return this.movieService.getMovieByMovieID(movieID);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/all")
	public @ResponseBody List<Movie> getAllMovies(HttpServletRequest req) {
		return this.movieService.getAllMovies();
		
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/insert" )
	public void insertMovie(HttpServletRequest req, @RequestBody Movie movie) {
		this.movieService.insertMovie(movie);
	}
	
}
