package com.icin.dao;

import org.springframework.data.repository.CrudRepository;

import com.icin.model.User;

public interface UserRepo extends CrudRepository<User, Long> {
	User findByMailid(String mailid);

	User findByFullname(String name);
}
