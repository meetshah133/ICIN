package com.icin.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.icin.model.Transaction;
import com.icin.exceptions.InvalidTransactionException;
import com.icin.service.TransactionService;




/**
 * REST controller for transaction related functions
 *
 */
@RestController
public class TransactionController {

    /*
     * Instance variable for transaction related services
     */
    @Autowired
    private TransactionService transactionService;
    
    /**
     * POST method to transfer money between two bank accounts
     * @param transaction - Container object carrying details about the transaction
     * @return HTTP status code or an error message according to the result of a transaction
     */
    @PostMapping(path = "/transfer")
    @CrossOrigin(origins = "http://localhost:4200")
    public Object transferMoney(@RequestBody Transaction transaction) {

    	  transactionService.transferMoney(transaction);
         
          return transaction;
        

    }
}
