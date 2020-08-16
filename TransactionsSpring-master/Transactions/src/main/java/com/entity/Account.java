package com.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains information regarding a bank account.
 * It holds information related to the account holder, balance, 
 * and other account related information.
 *
 */
@Entity
@Table(name = "accounts")
public class Account {

    /**
     * Unique bank account ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    /**
     * Name of account holder
     */
    @JsonProperty(required = true)
    private String accountHolder;

    /**
     * String branch
     */
    @JsonProperty(required = true)
    private String bank;

    /**
     * Available balance in the account
     */
    @JsonProperty(required = true)
    private BigDecimal accountBalance;

    /**
     * Default currency for transactions
     */
    @JsonProperty(required = true)
    private String email;

    
    public Account() {

    }

    /**
     * Constructor using fields
     * @param accountHolder
     * @param branchCode
     * @param accountBalance
     * @param currencyCode
     */
    public Account(String accountHolder, String bank,
            BigDecimal accountBalance, String email) {
        super();
        this.accountHolder = accountHolder;
        this.bank = bank;
        
        this.accountBalance = accountBalance;
        this.email = email;
        //this.transactions = new ArrayList<Transaction>();
    }

  
    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        } else if (this == object) {
            return true;
        }

        Account thisAccount = (Account) object;

        if (accountId != thisAccount.accountId) {
            return false;
        } else if (!accountHolder.equals(thisAccount.accountHolder)) {
            return false;
        } else if (!bank.equals(thisAccount.bank)) {
            return false;
        } else if (!accountBalance.equals(thisAccount.accountBalance)) {
            return false;
        }
        return true;

    }

    public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
    public int hashCode() {
        int result = (int) (accountId ^ (accountId >>> 32));
        result = 31 * result + accountHolder.hashCode();
        result = 31 * result + bank.hashCode();
        result = 31 * result + accountBalance.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountHolder=" + accountHolder + ", bank=" + bank
				+ ", accountBalance=" + accountBalance + ", email=" + email + "]";
	}

    
    

}
