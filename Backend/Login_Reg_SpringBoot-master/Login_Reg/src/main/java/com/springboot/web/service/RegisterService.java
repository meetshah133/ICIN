package com.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MyRepo;
import com.springboot.web.model.User;

@Service
public class RegisterService {
	
	@Autowired
	MyRepo repo;
	
	public User addUser(User user)
	{
		return repo.save(user);
	}
	

	
	public User matchEmailPassword(String mailid, String password)
	{
		return repo.findByMailidAndPassword(mailid, password);
	}
}
