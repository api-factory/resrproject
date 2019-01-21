package com.wipro.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.restapi.model.Account;
import com.wipro.restapi.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountBalanceCheckController {
	@Autowired
	private AccountService accountService;

	/**
	 * 
	 * This api returns balance of all account present in bankABC
	 * 
	 * @return list of Accounts in bankABC
	 */
	@RequestMapping(value="/getbalancelist",method=RequestMethod.GET) 
	public List<Account> getAllAccountListwithBalance() {
		return accountService.getAllAccountListwithBalance(); 
	}

	/**
	 * This api returns balance of account according to customer number 
	 * present in bankABC.
	 * 
	 * @return list of Accounts with Customer Number
	*/
	@GetMapping("/getcustomerbalance/{customerNumber}")
	public List<Account> getCustomerBalance(@PathVariable String customerNumber)
	{
		return accountService.getCustomerAccountBalance(customerNumber);
	}
	
	/**
	 * This api returns balance of account according to account Number
	 * 
	 * @return list of Accounts with Customer Number
	*/
	@GetMapping("/getbalancebyaccount/{accountNumber}")
	public Optional<Account> getBalanceByAccount(@PathVariable Long accountNumber)
	{
		return accountService.getBalanceByAccount(accountNumber);
	}
	
}
