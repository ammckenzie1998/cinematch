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

import com.revature.models.Lists;
import com.revature.services.ListsService;


@Controller
@RequestMapping(value = "/lists")
//@CrossOrigin(origins = "http://cinematch.s3-website-us-east-1.amazonaws.com", allowCredentials = "true")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true") //dev
public class ListsController {
	
	@Autowired
	private ListsService listsService;
	
	//Works in postman using get and params
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/movieID")
	public @ResponseBody List<Lists> getListsByMovieID(HttpServletRequest req, @RequestParam("movieID") int movieID) {
		return this.listsService.getListsByMovieID(movieID);
	}
	
	//Works in postman using get and params
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/userID")
	public @ResponseBody List<Lists> getListsByUserID(HttpServletRequest req, @RequestParam("userID") int userID) {
		return this.listsService.getListsByUserID(userID);
	}
	
	//Works in postman using post and JSON
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/insert")
	public void insertLists(HttpServletRequest req, @RequestBody Lists list) {
		this.listsService.insertList(list);
	}
	
	//Works in postman using get and params
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/user/likedlist")
	public @ResponseBody List<Lists> getLikedByUserID(HttpServletRequest req, @RequestParam("userID") int userID) {
		return this.listsService.getLikedByUserID(userID);
	}
	//Works in postman using get and params
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/user/watchlist")
	public @ResponseBody List<Lists> getWatchListByUserID(HttpServletRequest req, @RequestParam("userID") int userID) {
		return this.listsService.getWatchListByUserID(userID);
	}
	
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value = "/like")
	public void insertLike(HttpServletRequest req, @RequestParam("movieID") int movieID ) {
		this.listsService.insertLike(Integer.parseInt(req.getSession(false).getAttribute("userID").toString()), movieID);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value = "/removelike")
	public void removeLike(HttpServletRequest req, @RequestParam("movieID") int movieID ) {
		this.listsService.removeLike(Integer.parseInt(req.getSession(false).getAttribute("userID").toString()), movieID);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value = "/watch")
	public void insertWatch(HttpServletRequest req, @RequestParam("movieID") int movieID ) {
		this.listsService.insertWatchList(Integer.parseInt(req.getSession(false).getAttribute("userID").toString()), movieID);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value = "/removewatch")
	public void removeWatch(HttpServletRequest req, @RequestParam("movieID") int movieID ) {
		this.listsService.removeWatchList(Integer.parseInt(req.getSession(false).getAttribute("userID").toString()), movieID);
	}
	
}
