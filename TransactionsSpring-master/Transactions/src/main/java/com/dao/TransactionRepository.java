package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Transaction;

/**
 * Repository created for the transaction related object
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    /**
     * Finds all transactions for the account
     * @param accountId - Unique account ID
     * @return List of transactions for the given account
     */
    @Query("SELECT transaction FROM Transaction transaction "
            + "WHERE transaction.sourceAccountId = ?1"
            + "OR transaction.destinationAccountId = ?1")
    List<Transaction> retrieveTransactionsForAccount(long accountId);

}
