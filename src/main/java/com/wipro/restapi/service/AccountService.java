package com.wipro.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.restapi.exception.UserAccountNotFoundException;
import com.wipro.restapi.model.Account;
import com.wipro.restapi.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	public AccountService() {	
	}


	public List<Account> getAllAccountListwithBalance(){
		ArrayList<Account> accounts= new ArrayList<Account>();
		
		accountRepository.findAll().forEach(accounts::add);
		if(accounts.isEmpty())
		{
			throw new UserAccountNotFoundException("any user Account");
		}
		
		return accounts;
	}

	public List<Account> getCustomerAccountBalance(String customerNumber)
	{
		ArrayList<Account> accountsWithCustomerNumber= new ArrayList<Account>();
		accountRepository.findByCustomerNumber(customerNumber).forEach(accountsWithCustomerNumber::add);
		if(accountsWithCustomerNumber.isEmpty())
		{
			throw new UserAccountNotFoundException("customer number "+customerNumber);
		}
		
		return accountsWithCustomerNumber;
	}


	public Optional<Account> getBalanceByAccount(Long accountNumber) {
		
		Optional<Account> account=accountRepository.findById(accountNumber);
		if(!account.isPresent())
		{
			throw new UserAccountNotFoundException("account number"+ accountNumber);
		}
		
		return account;
	}



}
