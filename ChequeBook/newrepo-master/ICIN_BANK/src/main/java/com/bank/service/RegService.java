package com.bank.service;

import java.util.List;

import org.aspectj.weaver.ast.Test;

import com.bank.model.User;

public interface RegService {
	public User createUser(User user);	
	public User getUserByUid(int uid);	
	public User updateUser(User user);
	public void deleteUser(int uid);
	public List<User> getAllUsers();
	public Boolean isUser(User user);
	public Boolean isAdmin(User user);
	public Boolean isValidPass(User user);
}
