package com.revature.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepo;

@Service("UserService")
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User login(String username, String password) {
		User fetched;
		try {
			fetched = this.userRepo.getUserByUsername(username);
			if(fetched.getPassword().equals(password)) {
				//login succeeded, so pass back user without password
				fetched.setPassword(null);
			} else {
				//login failed due to invalid password, so just pass back the username
				fetched = new User(0, username, null, null, null); 
			}
		}catch(NoResultException e) {
			//login failed due to invalid username
			fetched = null;
		}
		return fetched;
	}
	
	public User getUserByUsername(String username) {
		User fetched;
		try {
			fetched = this.userRepo.getUserByUsername(username);
			fetched.setPassword(null);
		}catch(NoResultException e) {
			fetched = null;
		}
		return fetched;
	}
	
	public boolean registerUser(User u) {
		boolean result;
		if(u.getUsername() != null && u.getPassword() != null && u.getFirstName() != null && u.getLastName() != null){
			result = userRepo.insertUser(u);
		} else {
			result = false;
		}
		return result;
	}

	public List<User> getAllUsers() {
		List<User> users = userRepo.selectAllUsers();
		for(User u : users) {
			u.setPassword(null);
		}
		return users;
	}

}