package com.icin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.model.PersonalTransaction;

public interface PersonalTransactionDao extends JpaRepository<PersonalTransaction, Integer>{

}
