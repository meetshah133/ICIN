package com.icin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonalTransaction {
	
	@Id
	@GeneratedValue
	private int transactionId;
	private long accNo;
	private Date date;
	private Long prevBalance;
	private Long newBalance;
	private String transactionType;
	private String accType;
	
	
	public PersonalTransaction(long accNo, Date date, Long prevBalance, Long newBalance, String transactionType,
			String accType) {
		super();
		this.accNo = accNo;
		this.date = date;
		this.prevBalance = prevBalance;
		this.newBalance = newBalance;
		this.transactionType = transactionType;
		this.accType = accType;
	}
	public Long getPrevBalance() {
		return prevBalance;
	}
	public void setPrevBalance(Long prevBalance) {
		this.prevBalance = prevBalance;
	}
	public Long getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(Long newBalance) {
		this.newBalance = newBalance;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	
	
	
	
}
