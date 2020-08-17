package com.icin.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.icin.exceptions.InvalidAccountException;
import com.icin.exceptions.InvalidTransactionException;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class to handle transaction related services.
 * An object of this class will have information regarding
 * the transaction carried out between two accounts
 *
 */
@Entity
@Table(name = "transactions")
public class Transaction {

    /**
     * Unique Transaction ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;
    
    
    /**
     * Date on which transaction was created
     */
    //private Date creationDate;
    
    /**
     * Description for the optional message
     */
    private String description;

    /**
     * Amount for the transaction in question
     */
    @JsonProperty (required = true)
    private Long transactionAmount;

    
    /**
     * Long integer Unique ID of the source account
     */
    
    
    
    @JsonProperty (required = true)
    private int sourceAccountnumber;

    /**
     * Long integer Unique ID of the destination account
     */
    @JsonProperty (required = true)
    private int destinationAccountnumber;
    
    @JsonProperty (required = true)
    private String IFSC;

    public Transaction() {

    }

    
    

    public Transaction(String description, Long transactionAmount, int sourceAccountnumber,
			int destinationAccountnumber, String IFSC) {
		super();
		//this.creationDate = creationDate;
		this.description = description;
		this.transactionAmount = transactionAmount;
		this.sourceAccountnumber = sourceAccountnumber;
		this.destinationAccountnumber = destinationAccountnumber;
		this.IFSC = IFSC;
	}

   

	

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Account account;*/

    public Long getTransactionAmount() {
		return transactionAmount;
	}




	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}




	public int getSourceAccountnumber() {
		return sourceAccountnumber;
	}




	public void setSourceAccountnumber(int sourceAccountnumber) {
		this.sourceAccountnumber = sourceAccountnumber;
	}




	public int getDestinationAccountnumber() {
		return destinationAccountnumber;
	}




	public void setDestinationAccountnumber(int destinationAccountnumber) {
		this.destinationAccountnumber = destinationAccountnumber;
	}




	public String getIFSC() {
		return IFSC;
	}




	public void setIFSC(String iFSC) {
		this.IFSC = iFSC;
	}




	@Override
    public String toString() {
        return String.format(
                "Transaction [transactionId = %s, " + 
                "description = %s" +
                ", transactionAmount = %s" + 
                
                ", sourceAccountId = %s" +
                ", destinationAccountId = %s]",
                transactionId, description,
                transactionAmount,
                 sourceAccountnumber,
                destinationAccountnumber);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;
        else if (this == object)
            return true;

        Transaction thisTransaction = (Transaction) object;
        /*
        if (!creationDate.equals(thisTransaction.creationDate))
            return false;
        else */if (!description.equals(thisTransaction.description))
            return false;
        else if (!transactionAmount.equals(thisTransaction.transactionAmount))
            return false;
       
        else if (sourceAccountnumber!=thisTransaction.sourceAccountnumber)
            return false;
        return destinationAccountnumber==thisTransaction.destinationAccountnumber;

    }

   /* @Override
    public int hashCode() {
        int result = (int) (transactionId ^ (transactionId >>> 32));

        result = 31 * result + creationDate.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + transactionAmount.hashCode();
        
        result = 31 * result + sourceAccountnumber.hashCode();
        result = 31 * result + destinationAccountnumber.hashCode();
        return result;
    }*/

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }

    /**
     * Method to run validation tests on a transaction to make sure
     * that the completion of the same does not result in an unstable state
     * for the application
     * @param sourceAccount - Account from which amount will be deducted
     * @param destinationAccount - Account to which amount will be credited
     * 
     * @throws - Will throw custom exceptions if there are issue with the transaction
     */
    public void runValidationTests(PrimaryAccount sourceAccount, PrimaryAccount destinationAccount) {
        Long transactionAmount = getTransactionAmount();
        
        if (sourceAccount ==null || destinationAccount == null) {
            throw new InvalidAccountException(
                    String.format("Invalid source account %s "
                            + "or destination account %s", 
                            sourceAccount.getAccountNumber(),
                            destinationAccount.getAccountNumber()));
        }
        if (transactionAmount.compareTo(Long.valueOf(0)) <0) {
            throw new InvalidTransactionException(
                    String.format("Transaction %s is invalid"
                            + " due to negative value", getTransactionId()));
        }
//        if (sourceAccount.getAccountBalance().
//                subtract(transactionAmount).compareTo(Long.valueOf(0)) <0) {
//            throw new InvalidTransactionException(
//                    String.format("Transaction %s is invalid due to "
//                            + "insufficient balance for account %s",
//                    getTransactionId(), sourceAccount.getAccountId()));
//        }
       
    }
}
