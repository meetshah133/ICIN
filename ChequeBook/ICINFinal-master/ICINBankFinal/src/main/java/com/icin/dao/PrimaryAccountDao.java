package com.icin.dao;

import org.springframework.data.repository.CrudRepository;

import com.icin.model.PrimaryAccount;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);

}
