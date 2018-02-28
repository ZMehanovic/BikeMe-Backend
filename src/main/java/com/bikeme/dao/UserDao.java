package com.bikeme.dao;

import com.bikeme.model.User;

public interface UserDao {

	boolean checkUser(String username, String password);
	
	boolean createUser(User user);
}
