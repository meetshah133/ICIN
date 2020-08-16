package com.icin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icin.model.ChequeBook;
import com.icin.model.User;
import com.icin.service.ChequeBookService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckbookController{
	
	@Autowired
	ChequeBookService service;

	@PostMapping("/createcheque")
	@CrossOrigin(origins = "http://localhost:4200")
	public ChequeBook createChequeBook(@RequestBody ChequeBook chequebook) {
		System.out.println(chequebook);
		User user = chequebook.getUser();
		return service.createChequeBook(chequebook,user);
		
	}

	@GetMapping("/allcheques")
	public List<ChequeBook> AllChequeBooks() {
		return service.AllChequeBooks();
	}

	@GetMapping("/getcheque/{id}")
	public ChequeBook findChequebookById(@PathVariable("id") long id) {
		return service.findChequebookById(id);
	}

	@GetMapping("/admin/confirmchequetrue/{id}")
	public void ChequeBookRequestTrue(@PathVariable("id") long id) {
		service.ChequeBookRequestTrue(id);
		
	}

	@GetMapping("/admin/confirmchequefalse/{id}")
	public void ChequeBookRequestFalse(long id) {
		service.ChequeBookRequestFalse(id);
	}
	

}
