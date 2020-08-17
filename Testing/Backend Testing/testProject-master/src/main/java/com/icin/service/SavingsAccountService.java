package com.icin.service;

import java.security.Principal;
import java.util.List;

import com.icin.model.PrimaryAccount;
import com.icin.model.SavingsAccount;

public interface SavingsAccountService {
	
	public SavingsAccount createSavingsAccount();
	public List<SavingsAccount> getAllSavingsAccounts();
	public void deposit(Integer accNo, Long amount);
	public String withdraw(Integer accNo, Long amount);
    public SavingsAccount getAccount(int accNo);
	Long retrieveAccountBalance(long accountId);
}
