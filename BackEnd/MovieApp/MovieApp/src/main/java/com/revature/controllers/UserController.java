package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.revature.models.User;
import com.revature.services.UserService;

@Controller
@RequestMapping(value = "/user")
//@CrossOrigin(origins = "http://cinematch.s3-website-us-east-1.amazonaws.com", allowCredentials = "true")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true") //dev
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value = "/login")
	public @ResponseBody User login(HttpServletRequest req, @RequestBody User requested) {
		User user = this.userService.login(requested.getUsername(), requested.getPassword());
		if(user != null) {	//	a user exists for this username
			if(user.getId() != 0) {	//has an ID, is signed in
				HttpSession session = req.getSession();
				session.setAttribute("userID", user.getId());
			}
		}
		return user;
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping
	public @ResponseBody User getUser(HttpServletRequest req, @RequestParam("username") String username) {
		User user = null;
		if(req.getSession(false) != null) {
			user = this.userService.getUserByUsername(username);
		}
		return user;
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/list")
	public @ResponseBody List<User> getAllUsers(HttpServletRequest req){
		return this.userService.getAllUsers();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value = "/register")
	public void register(@RequestBody User requested) {
		this.userService.registerUser(requested);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value = "/logout")
	public void logOut(HttpServletRequest req) {
		if(req.getSession(false) != null) {
			req.getSession(false).invalidate();
		}
	}
}