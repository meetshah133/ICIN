


package com.icin.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/deposit/{accType}/{accNo}/{amount}" )
	@CrossOrigin(origins = "http://localhost:4200")
    public Object deposit(@PathVariable String accType, @PathVariable String accNo, @PathVariable String amount) {
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		if(accType.equals("Primary")) {
			System.out.println(accType);
			primaryAccountService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
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
	
	@GetMapping("/withdraw/{accType}/{accNo}/{amount}" )
	@CrossOrigin(origins = "http://localhost:4200")
    public Object withdraw(@PathVariable String accType, @PathVariable String accNo, @PathVariable String amount) {
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
    @GetMapping(path = "/accounts/{accountNumber}/balance")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long retrieveAccountBalance(@PathVariable int accountNumber) {
        PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountNumber);
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
    @GetMapping(path = "/accounts/{accountId}/transactions")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Transaction> retrieveAccountTransactions(@PathVariable int accountId) {
        //PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountId);
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
            @PathVariable int accountNo) {
        PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountNo);
		/*
		 * if (!account.isPresent()) { throw new AccountNotFoundException(
		 * String.format("Account %s not found.", accountId)); }
		 */
        AccountSnapshotContainer accountSnapshot =
                new AccountSnapshotContainer(
                        account.getAccountNumber(), 
                        account.getAccountBalance(), 
                        transactionService.retrieveTransactionsForAccount(accountNo));
        return accountSnapshot;
    }

}
