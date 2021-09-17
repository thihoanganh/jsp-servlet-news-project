package com.tintuc24h.services;

import java.util.List;

import com.tintuc24h.models.LoginResult;
import com.tintuc24h.models.User;

public interface IUserSerivce {
	Integer isUserExist(String username);
	User create(User user);
	LoginResult Login(String username,String password);
	Boolean isUserBlock(String username);
	List<User> findAll();
	User findByUsername(String username);
}
