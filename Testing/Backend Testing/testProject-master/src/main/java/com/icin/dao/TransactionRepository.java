package com.icin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icin.model.Transaction;

/**
 * Repository created for the transaction related object
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    
    /**
     * Finds all transactions for the account
     * @param accountId - Unique account ID
     * @return List of transactions for the given account
     */
    @Query("SELECT transaction FROM Transaction transaction "
            + "WHERE transaction.sourceAccountnumber = ?1"
            + "OR transaction.destinationAccountnumber = ?1")
    List<Transaction> retrieveTransactionsForAccount(int accountId);

}
