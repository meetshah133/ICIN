package com.bank.service.impl;

import java.util.List;

import org.aspectj.weaver.ast.Test;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.RegDAO;
import com.bank.model.User;
import com.bank.service.RegService;

@Service
public class RegServiceImpl implements RegService {
	
	@Autowired
	private RegDAO regdao;
	

	@Override
	public User createUser(User user) {
		return regdao.save(user);
	}

	@Override
	public User getUserByUid(int uId) {
		return regdao.getUserByUid(uId);
	}

	@Override
	public void deleteUser(int uId) {
		regdao.deleteById(uId);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) regdao.findAll();
	}
	

	@Override
	public User updateUser(User user) {
		return regdao.save(user);
	}
	
	@Override
	public Boolean isUser(User user) {
		List<User> listOfUsers =(List<User>)regdao.findAll(); 
		for(int i=0;i<listOfUsers.size();i++) {
			if ((listOfUsers.get(i)).getUemail()==user.getUemail()) {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public Boolean isAdmin(User user) {
		if (user.getUemail()=="admin@gmail.com" & user.getUpass()=="admin123") {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean isValidPass(User user) {
		if (user.getUpass()==user.getCpass()) {
			return true;
		}
		return false;
		
		
	}
	
	

}
