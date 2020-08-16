package com.icin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icin.model.PrimaryAccount;
import com.icin.model.SavingsAccount;
import com.icin.service.PrimaryAccountService;
import com.icin.service.SavingsAccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AccController {
	
	@Autowired
	private PrimaryAccountService primaryAccountService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@PostMapping("/deposit" )
	@CrossOrigin(origins = "http://localhost:4200")
    public Object deposit(@RequestParam String accType, @RequestParam String accNo, @RequestParam String amount) {
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		if(accType.equals("Primary")) {
			System.out.println(accType);
			primaryAccountService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
			PrimaryAccount primaryAcc = primaryAccountService.getAccount(Integer.parseInt(accNo));
			return primaryAcc;
		}	
		else {
			System.out.println(accType);
			savingsAccountService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
			SavingsAccount savingsAcc = savingsAccountService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
		}
			
    }
	
	@PostMapping("/withdraw" )
	@CrossOrigin(origins = "http://localhost:4200")
    public Object withdraw(@RequestParam String accType, @RequestParam String accNo, @RequestParam String amount) {
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		if(accType.equals("Primary")) {
			System.out.println(accType);
			String val = primaryAccountService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done")) {
			PrimaryAccount primaryAcc = primaryAccountService.getAccount(Integer.parseInt(accNo));
			return primaryAcc;
			}
			else {
				return "Insufficient Balance";
			}
		}	
		else {
			System.out.println(accType);
			String val = savingsAccountService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done")) {
			SavingsAccount savingsAcc = savingsAccountService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
			}
			else
			{
				return "Insufficient Balance";
			}
		}
			
    }
}
