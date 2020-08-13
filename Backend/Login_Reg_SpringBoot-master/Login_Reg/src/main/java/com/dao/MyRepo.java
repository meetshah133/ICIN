package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.web.model.User;

@Repository
public interface MyRepo extends JpaRepository<User, Integer>{
	User findByMailid(String mailid);
	User findByMailidAndPassword(String mailid, String password);
}
