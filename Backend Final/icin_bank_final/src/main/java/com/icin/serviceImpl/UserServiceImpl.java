package com.icin.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.dao.UserRepo;
import com.icin.model.User;
import com.icin.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	 
	 @Autowired
	 private UserRepo userRepo;
	 
	 public User findByEmail(String email) {
	        return userRepo.findByMailid(email);
	    }

	@Override
	public User findByUsername(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByFullname(String name) {
		return userRepo.findByFullname(name);
	}
}
