package com.icin.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.dao.MyRepo;
import com.icin.model.User;
import com.icin.service.PrimaryAccountService;
import com.icin.service.SavingsAccountService;


@Service
public class RegisterService {
	
	@Autowired
	MyRepo repo;
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Autowired
	private PrimaryAccountService primaryAccountService; 
		
	
	public User addUser(User user)
	{
		user.setPrimaryAccount(primaryAccountService.createPrimaryAccount());
        user.setSavingsAccount(savingsAccountService.createSavingsAccount());
        return repo.save(user);
	}
	
	public User matchEmailPassword(String mailid, String password)
	{
		return repo.findByMailidAndPassword(mailid, password);
	}
}
