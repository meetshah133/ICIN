package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.User;
import com.bank.service.RegService;

@RestController
public class RegController{
	
	@Autowired
	private RegService service;
	

	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		if(!service.isUser(user)) {
			if(service.isValidPass(user)) {
				return service.createUser(user);
			}
		}
		return null;
	}
	@GetMapping("/getuser/{uId}")
	public User getUserByUid(@PathVariable("uId") int uId) {
		return service.getUserByUid(uId);
	}

	@PutMapping("/updateuser")
	public User updateUser(User user) {
		return service.updateUser(user);
	}

	@GetMapping("/getallusers")
	public List<User> getAllUsers() {
			return service.getAllUsers();
	}

	@DeleteMapping("/deleteuser/{uId}")
	public void deleteUser(@PathVariable("uId")int uId) {
		service.deleteUser(uId);
	}

}
