package com.icin.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.model.PrimaryAccount;
import com.icin.model.SavingsAccount;
import com.icin.model.SavingsTransaction;
import com.icin.model.User;
import com.icin.service.SavingsAccountService;
import com.icin.service.UserService;
import com.icin.dao.SavingsAccountDao;
import com.icin.dao.UserRepo;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService{

    @Autowired
    private SavingsAccountDao savingsAccountDao;
    
    @Autowired
    private UserService userService;
	private static int nextAccountNumber = 11223344;
	 
	@Override
	public SavingsAccount createSavingsAccount() {
	        SavingsAccount savingsAccount = new SavingsAccount();
	        savingsAccount.setAccountBalance(new Long(0));
	        savingsAccount.setAccountNumber(++nextAccountNumber);
	        nextAccountNumber += 1;
	        System.out.println(savingsAccount);
	        savingsAccountDao.save(savingsAccount);

	        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
	    }
	@Override 
	public void deposit( Integer accNo, Long amount) {
				SavingsAccount savingsAccount = savingsAccountDao.findByAccountNumber(accNo);
		        savingsAccount.setAccountBalance((long) (savingsAccount.getAccountBalance() + amount) );
		        savingsAccountDao.save(savingsAccount);


//	            Date date = new Date();
//	            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Deposit to savings Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
//	            transactionService.saveSavingsDepositTransaction(savingsTransaction);
	        }
	    
	    
	    public String withdraw(Integer accNo, Long amount) {
	    	    SavingsAccount savingsAccount = savingsAccountDao.findByAccountNumber(accNo);
	    	    if(savingsAccount.getAccountBalance()>=amount) {
	    	    	savingsAccount.setAccountBalance((long) (savingsAccount.getAccountBalance() - amount) );
		            savingsAccountDao.save(savingsAccount);
		            return "Done";

	    	    }
	    	    else {
	    	    	return "Insufficient balance";
	    	    }
	            
//	            Date date = new Date();
//	            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Withdraw from savings Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
//	            transactionService.saveSavingsWithdrawTransaction(savingsTransaction);
	        
	    }
	    
	   
		@Override
		public List<SavingsAccount> getAllSavingsAccounts() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SavingsAccount getAccount(int accNo) {
			return savingsAccountDao.findByAccountNumber(accNo);
		}
}
