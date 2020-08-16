package com.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountRepository;
import com.entity.Account;
import com.entity.AccountSnapshotContainer;
import com.exceptions.AccountNotFoundException;
import com.service.AccountService;
import com.service.TransactionService;



@Service
public class AccountServiceImplementation implements AccountService{

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private TransactionService transactionService;
    
    @Override
    public BigDecimal retrieveAccountBalance(long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accountId));
        }
        return account.get().getAccountBalance();
    }
    
    
    @Override
    public AccountSnapshotContainer retrieveAccountBalanceAndListOfTransactions(long accountId) {

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
