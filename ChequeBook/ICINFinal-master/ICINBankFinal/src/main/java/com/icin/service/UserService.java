package com.icin.service;

import java.util.List;
import java.util.Set;

import com.icin.model.User;
public interface UserService {
    User findByEmail(String email);
	User findByUsername(String name);
	User findByFullname(String name);
}
