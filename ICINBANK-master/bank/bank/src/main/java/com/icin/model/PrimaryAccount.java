package com.icin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/*Primary account model*/

@Entity
public class PrimaryAccount {

    @Id
    @GeneratedValue
    private Long id;
    private int accountNumber;
    private Long accountBalance;
    /*
    @OneToMany(mappedBy = "primaryAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrimaryTransaction> primaryTransactionList;
	*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

  
    public Long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	/*
	public List<PrimaryTransaction> getPrimaryTransactionList() {
        return primaryTransactionList;
    }

    public void setPrimaryTransactionList(List<PrimaryTransaction> primaryTransactionList) {
        this.primaryTransactionList = primaryTransactionList;
    }
	*/

}



