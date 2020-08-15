package com.service;

import java.math.BigDecimal;

import com.entity.AccountSnapshotContainer;


/**
 * Service stub for Account related functions
 *
 */
public interface AccountService {
    /**
     * Finds account balance for given account
     * @param accountId Unique account ID
     * @return Available balance for account
     */
    public BigDecimal retrieveAccountBalance(long accountId);
    
    /**
     * Finds account balance and list of transactions for given account
     * @param accountId Unique account ID
     * @return Available balance for account
     */
    public AccountSnapshotContainer retrieveAccountBalanceAndListOfTransactions(long accountId);

}
