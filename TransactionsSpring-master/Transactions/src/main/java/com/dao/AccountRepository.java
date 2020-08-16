package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Account;

/**
 * Repository created for the account related object
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
