package com.revature.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository("UserRepoImp")
@Transactional
public class UserRepoImp implements UserRepo {
	
	private SessionFactory sessFact;

	public UserRepoImp(SessionFactory sessFact) {
		super();
		this.sessFact = sessFact;
	}

	@Override
	public boolean insertUser(User user) {
		sessFact.getCurrentSession().save(user);
		return true;
	}

	@Override
	public List<User> selectAllUsers() {
		return sessFact.getCurrentSession().createQuery("from User", User.class).list();
	}

	@Override
	public User getUserByUsername(String username) {
		return sessFact.getCurrentSession().createQuery("from User where username = '" + username + "'", User.class).getSingleResult();
	}
	
	@Override
	public User getUserById(int id) {
		return sessFact.getCurrentSession().createQuery("from User where id = " + id, User.class).getSingleResult();
	}

	@Override
	public boolean updateUser(User user) {
		sessFact.getCurrentSession().update(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		sessFact.getCurrentSession().delete(user);
		return true;
	}

}
