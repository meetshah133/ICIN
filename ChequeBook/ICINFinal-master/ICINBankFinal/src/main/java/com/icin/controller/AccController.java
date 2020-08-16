


package com.icin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.icin.model.AccountSnapshotContainer;
import com.icin.model.Transaction;
import com.icin.dao.PrimaryAccountDao;
import com.icin.exceptions.AccountNotFoundException;
import com.icin.model.PrimaryAccount;
import com.icin.model.SavingsAccount;
import com.icin.service.PrimaryAccountService;
import com.icin.service.SavingsAccountService;
import com.icin.service.TransactionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccController {
	
	@Autowired
	private PrimaryAccountService primaryAccountService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	
	@PostMapping("/deposit" )
	@CrossOrigin(origins = "http://localhost:4200")
    public Object deposit(@RequestParam String accType, @RequestParam String accNo, @RequestParam String amount) {
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		if(accType.equals("Primary")) {
			System.out.println(accType);
			primaryAccountService.deposit(Long.parseLong(accNo) , Long.parseLong(amount));
			PrimaryAccount primaryAcc = primaryAccountService.getAccount(Integer.parseInt(accNo));
			return primaryAcc;
		}	
		else {
			System.out.println(accType);
			savingsAccountService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
			SavingsAccount savingsAcc = savingsAccountService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
		}
			
    }
	
	@PostMapping("/withdraw" )
	@CrossOrigin(origins = "http://localhost:4200")
    public Object withdraw(@RequestParam String accType, @RequestParam String accNo, @RequestParam String amount) {
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		if(accType.equals("Primary")) {
			System.out.println(accType);
			String val = primaryAccountService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done")) {
			PrimaryAccount primaryAcc = primaryAccountService.getAccount(Integer.parseInt(accNo));
			return primaryAcc;
			}
			else {
				return "Insufficient Balance";
			}
		}	
		else {
			System.out.println(accType);
			String val = savingsAccountService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done")) {
			SavingsAccount savingsAcc = savingsAccountService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
			}
			else
			{
				return "Insufficient Balance";
			}
		}
			
    }
	
	@Autowired
    private TransactionService transactionService;
    
    /**
     * Finds all available accounts in the system
     * @return - List of accounts
     */
    @GetMapping(path="/accounts")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<PrimaryAccount> retrieveAllAccounts() {
        return primaryAccountDao.findAll();
    }

    /**
     * Finds the balance available for a given account
     * @param accountId - Unique account ID
     * @return Balance available for an account
     */
    @GetMapping(path = "/accounts/{accountId}/balance")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long retrieveAccountBalance(@PathVariable long accountId) {
        PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountId);
//        if (!account.isPresent()) {
//            throw new AccountNotFoundException(
//                  String.format("Account %s not found.", accountId));
//        }
        return account.getAccountBalance();
    }
    
    /**
     * Finds all transactions for a given bank account
     * @param accountId - Unique account ID
     * @return List of transactions for a given bank account
     */
    @GetMapping(path = "/accounts/{accountNumber}/transactions")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Transaction> retrieveAccountTransactions(@PathVariable String accountNumber) {
    	long accountId = Long.parseLong(accountNumber);
        PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountId);
		/*
		 * if (!account.isPresent()) { throw new AccountNotFoundException(
		 * String.format("Account %s not found.", accountId)); }
		 */
        return transactionService.retrieveTransactionsForAccount(accountId);
    }
    
    /**
     * Finds the available balance and the list of transactions
     * for the given account
     * @param accountId - Unique bank account ID
     * @return Available balance and list of transactions for a given bank account
     */
    @GetMapping(path = "/accounts/{accountId}/snapshot")
    @CrossOrigin(origins = "http://localhost:4200")
    public AccountSnapshotContainer retrieveAccountBalanceAndListOfTransactions(
            @PathVariable int accountId) {
        PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountId);
		/*
		 * if (!account.isPresent()) { throw new AccountNotFoundException(
		 * String.format("Account %s not found.", accountId)); }
		 */
        AccountSnapshotContainer accountSnapshot =
                new AccountSnapshotContainer(
                        (long)account.getAccountNumber(), 
                        account.getAccountBalance(), 
                        transactionService.retrieveTransactionsForAccount(accountId));
        return accountSnapshot;
    }

}
