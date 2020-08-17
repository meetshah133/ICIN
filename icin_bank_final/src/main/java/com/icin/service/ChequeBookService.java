package com.icin.service;

import java.util.List;

import com.icin.model.ChequeBook;
import com.icin.model.User;

public interface ChequeBookService {
	public ChequeBook createChequeBook(ChequeBook chequebook,User user);
	public List<ChequeBook> AllChequeBooks();
	public ChequeBook findChequebookById(long id);
	public void ChequeBookRequestTrue(long id);
	public void ChequeBookRequestFalse(long id);
	

}
