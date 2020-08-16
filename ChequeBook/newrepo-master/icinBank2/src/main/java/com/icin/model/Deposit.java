package com.icin.model;

public class Deposit {
	private String accType;
	private String accNo;
	private int amount;
	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Deposit(String accType, String accNo, int amount) {
		super();
		this.accType = accType;
		this.accNo = accNo;
		this.amount = amount;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
