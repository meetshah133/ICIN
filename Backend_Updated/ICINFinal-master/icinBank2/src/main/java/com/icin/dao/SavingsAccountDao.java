package com.icin.dao;


import org.springframework.data.repository.CrudRepository;

import com.icin.model.SavingsAccount;


public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);

}
