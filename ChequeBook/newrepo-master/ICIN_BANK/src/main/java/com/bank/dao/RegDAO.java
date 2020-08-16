package com.bank.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.User;

@Repository
public interface RegDAO extends CrudRepository<User,Integer> {
	public User getUserByUid(int uid);

}
