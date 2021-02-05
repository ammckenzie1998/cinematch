package com.revature.repositories;

import java.util.List;

import com.revature.models.User;


public interface UserRepo {
	
	//CRUD Methods
	
	//Create
	boolean insertUser(User user);
	
	//Read
	public List<User> selectAllUsers();
	
	//Read 
	public User getUserByUsername(String username);
	public User getUserById(int id);
	
	//Update
	boolean updateUser(User user);
	
	//Delete
	boolean deleteUser(User user);

}
