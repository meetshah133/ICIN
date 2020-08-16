package com.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountRepository;
import com.dao.TransactionRepository;
import com.entity.Account;
import com.entity.AccountSnapshotContainer;
import com.entity.Transaction;
import com.exceptions.AccountNotFoundException;
import com.exceptions.InvalidAccountException;
import com.service.AccountService;
import com.service.TransactionService;


@Service
public class TransactionServiceImplementation implements TransactionService{
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Transaction> retrieveTransactionsForAccount(long accountId) {
        
        return transactionRepository.retrieveTransactionsForAccount(accountId);
    }
    
    @Override
    public void transferMoney(Transaction transaction) {

        Optional<Account> sourceAccount = 
                accountRepository.findById(transaction.getSourceAccountId());
        Optional<Account> destinationAccount = 
                accountRepository.findById(transaction.getDestinationAccountId());
        if (!sourceAccount.isPresent() || !destinationAccount.isPresent()) {
            throw new InvalidAccountException(
                    "Invalid source account " + "or destination account ");
        }

        transaction.runValidationTests(
                sourceAccount.get(), destinationAccount.get());

        BigDecimal transactionAmount = 
                transaction.getTransactionAmount();
        sourceAccount.get().setAccountBalance(
                sourceAccount.get().getAccountBalance()
                .subtract(transactionAmount));
        destinationAccount.get().setAccountBalance(
                destinationAccount.get().getAccountBalance()
                .add(transactionAmount));

        transactionRepository.save(transaction);

        accountRepository.save(sourceAccount.get());
        accountRepository.save(destinationAccount.get());

    }

}
