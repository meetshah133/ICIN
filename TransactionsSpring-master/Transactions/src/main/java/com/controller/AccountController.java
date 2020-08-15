package com.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exceptions.AccountNotFoundException;
import com.entity.Account;
import com.entity.AccountSnapshotContainer;
import com.entity.Transaction;
import com.dao.AccountRepository;
import com.service.TransactionService;

/**
 * Controller to perform tasks related to account
 *
 */
@RestController
public class AccountController {
    
    /**
     * Instance variable related to account repository
     * to carry out DB related tasks
     */
    @Autowired
    private AccountRepository accountRepository;
    
    /**
     * Instance variable related to services provided by account
     */
    @Autowired
    private TransactionService transactionService;
    
    /**
     * Finds all available accounts in the system
     * @return - List of accounts
     */
    @GetMapping(path="/accounts")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Account> retrieveAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Finds the balance available for a given account
     * @param accountId - Unique account ID
     * @return Balance available for an account
     */
    @GetMapping(path = "/accounts/{accountId}/balance")
    @CrossOrigin(origins = "http://localhost:4200")
    public BigDecimal retrieveAccountBalance(@PathVariable long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accountId));
        }
        return account.get().getAccountBalance();
    }
    
    /**
     * Finds all transactions for a given bank account
     * @param accountId - Unique account ID
     * @return List of transactions for a given bank account
     */
    @GetMapping(path = "/accounts/{accountId}/transactions")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Transaction> retrieveAccountTransactions(@PathVariable long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accountId));
        }
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
            @PathVariable long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accountId));
        }
        AccountSnapshotContainer accountSnapshot =
                new AccountSnapshotContainer(
                        account.get().getAccountId(), 
                        account.get().getAccountBalance(), 
                        transactionService.retrieveTransactionsForAccount(accountId));
        return accountSnapshot;
    }
}
