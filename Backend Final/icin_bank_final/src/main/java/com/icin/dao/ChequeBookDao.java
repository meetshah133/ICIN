package com.icin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.model.ChequeBook;

public interface ChequeBookDao extends JpaRepository<ChequeBook,Long> {
	

}
