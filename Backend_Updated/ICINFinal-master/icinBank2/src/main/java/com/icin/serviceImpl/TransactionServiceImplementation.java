package com.icin.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.dao.PrimaryAccountDao;
import com.icin.dao.TransactionRepository;

import com.icin.model.AccountSnapshotContainer;
import com.icin.model.PrimaryAccount;
import com.icin.model.Transaction;
import com.icin.exceptions.AccountNotFoundException;
import com.icin.exceptions.InvalidAccountException;

import com.icin.service.TransactionService;


@Service
public class TransactionServiceImplementation implements TransactionService{
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Override
    public List<Transaction> retrieveTransactionsForAccount(long accountId) {
        
        return transactionRepository.retrieveTransactionsForAccount(accountId);
    }
    
    @Override
    public void transferMoney(Transaction transaction) {

        Optional<PrimaryAccount> sourceAccount = 
        		primaryAccountDao.findById(transaction.getSourceAccountId());
        Optional<PrimaryAccount> destinationAccount = 
        		primaryAccountDao.findById(transaction.getDestinationAccountId());
        if (!sourceAccount.isPresent() || !destinationAccount.isPresent()) {
            throw new InvalidAccountException(
                    "Invalid source account " + "or destination account ");
        }

        transaction.runValidationTests(
                sourceAccount.get(), destinationAccount.get());

        Long transactionAmount = 
                transaction.getTransactionAmount();
        sourceAccount.get().setAccountBalance(
                sourceAccount.get().getAccountBalance() - transactionAmount); // subtraction logic
        destinationAccount.get().setAccountBalance(
                destinationAccount.get().getAccountBalance() + transactionAmount); // addition logic

        transactionRepository.save(transaction);

        primaryAccountDao.save(sourceAccount.get());
        primaryAccountDao.save(destinationAccount.get());

    }

	@Override
	public int retreiveAccountNumber(Long id) {
		Optional<PrimaryAccount> account =  primaryAccountDao.findById(id);
		int accNo = account.get().getAccountNumber();
		return accNo;
	}
    
    

}
