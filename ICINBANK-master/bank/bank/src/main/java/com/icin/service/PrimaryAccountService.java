package com.icin.service;

import java.security.Principal;
import java.util.List;

import com.icin.model.PrimaryAccount;

public interface PrimaryAccountService {
	public PrimaryAccount createPrimaryAccount();
	public List<PrimaryAccount> getAllPrimaryAccounts();
	public String withdraw(Integer accNo, Long amount);
	public void deposit(Integer accNo, Long amount);
	public PrimaryAccount getAccount(int accNo);
}
