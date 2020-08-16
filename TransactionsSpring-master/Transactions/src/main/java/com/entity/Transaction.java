package com.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.exceptions.InvalidAccountException;
import com.exceptions.InvalidTransactionException;
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
    private Date creationDate;

    /**
     * Description for the optional message
     */
    private String description;

    /**
     * Amount for the transaction in question
     */
    @JsonProperty (required = true)
    private BigDecimal transactionAmount;

    
    /**
     * Long integer Unique ID of the source account
     */
    @JsonProperty (required = true)
    private Long sourceAccountId;

    /**
     * Long integer Unique ID of the destination account
     */
    @JsonProperty (required = true)
    private Long destinationAccountId;
    
    @JsonProperty (required = true)
    private String IFSC;

    public Transaction() {

    }

    public Transaction(String description, BigDecimal transactionAmount,
                       Long sourceAccountId,
                       Long destinationAccountId,String IFSC) {
        this.description = description;
        this.transactionAmount = transactionAmount;
       
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
       
        this.IFSC=IFSC;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    

    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Account account;*/

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
                 sourceAccountId,
                destinationAccountId);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;
        else if (this == object)
            return true;

        Transaction thisTransaction = (Transaction) object;

        if (!creationDate.equals(thisTransaction.creationDate))
            return false;
        else if (!description.equals(thisTransaction.description))
            return false;
        else if (!transactionAmount.equals(thisTransaction.transactionAmount))
            return false;
       
        else if (!sourceAccountId.equals(thisTransaction.sourceAccountId))
            return false;
        return destinationAccountId.equals(thisTransaction.destinationAccountId);

    }

    @Override
    public int hashCode() {
        int result = (int) (transactionId ^ (transactionId >>> 32));

        result = 31 * result + creationDate.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + transactionAmount.hashCode();
        
        result = 31 * result + sourceAccountId.hashCode();
        result = 31 * result + destinationAccountId.hashCode();
        return result;
    }

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Method to run validation tests on a transaction to make sure
     * that the completion of the same does not result in an unstable state
     * for the application
     * @param sourceAccount - Account from which amount will be deducted
     * @param destinationAccount - Account to which amount will be credited
     * 
     * @throws - Will throw custom exceptions if there are issue with the transaction
     */
    public void runValidationTests(Account sourceAccount, Account destinationAccount) {
        BigDecimal transactionAmount = getTransactionAmount();
        
        if (sourceAccount ==null || destinationAccount == null) {
            throw new InvalidAccountException(
                    String.format("Invalid source account %s "
                            + "or destination account %s", 
                            sourceAccount.getAccountId(),
                            destinationAccount.getAccountId()));
        }
        if (transactionAmount.compareTo(BigDecimal.ZERO) <0) {
            throw new InvalidTransactionException(
                    String.format("Transaction %s is invalid"
                            + " due to negative value", getTransactionId()));
        }
        if (sourceAccount.getAccountBalance().
                subtract(transactionAmount).compareTo(BigDecimal.ZERO) <0) {
            throw new InvalidTransactionException(
                    String.format("Transaction %s is invalid due to "
                            + "insufficient balance for account %s",
                    getTransactionId(), sourceAccount.getAccountId()));
        }
       
    }
}
