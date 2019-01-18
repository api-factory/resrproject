package com.wipro.restapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.wipro.restapi.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	public Iterable<Account> findByCustomerNumber(String customerNumber);

}
