package com.wipro.restapi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.restapi.exception.InternalServerException;
import com.wipro.restapi.model.AccountBalance;
import com.wipro.restapi.model.Accounts;
import com.wipro.restapi.model.CustomerDetails;
import com.wipro.restapi.repository.CustomerDetailsReopsitory;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerDetailsReopsitory customerDetailsReopsitory;

	@RequestMapping("/accounts")
	public CustomerDetails getBankDetails(@RequestHeader(value = "mobNo") String mobNo) {
		if (mobNo.isEmpty()) {
			throw new InternalServerException("mobNo-" + mobNo);
		}

		CustomerDetails details = new CustomerDetails();

		details.setCustomerName("custname");
		details.setAadharNumber("1436543");
		details.setPanCardNumber("CVDLY4563E");

		Accounts accounts = new Accounts();

		accounts.setId(2536L);
		accounts.setCustomerAccountName("custName");
		accounts.setAccountNumber("DFG121154");
		accounts.setBankName("BOI");
		accounts.setAccountStatus("Active");
		accounts.setAccountType("Saving");
		accounts.setBranchName("Pune");
		accounts.setBranchId("DFGH1254");
		accounts.setIfsc("PSFG");

		Set<Accounts> banklist = new HashSet<Accounts>();
		banklist.add(accounts);
		banklist.add(accounts);

		details.setAccountsInfo(banklist);

		return details;
	}

	@RequestMapping("/checkAccountBalance")
	public AccountBalance checkAccountBalance(@RequestHeader(value = "mobNo") String mobNo,
			@RequestHeader(value = "accountNo") String accountNo) {

		if (mobNo.isEmpty()) {
			throw new InternalServerException("mobNo-" + mobNo);
		} else if (accountNo.isEmpty()) {
			throw new InternalServerException("accountNo-" + accountNo);
		}

		AccountBalance balanceInfo = new AccountBalance();

		balanceInfo.setBalance("212454");

		return balanceInfo;
	}

	@RequestMapping("/custaccountlist")
	@Secured("USER")
	public List<CustomerDetails> getBankDetailList(@RequestHeader(value = "mobNo") String mobNo) {
		/*
		 * if (mobNo.isEmpty()) { throw new InternalServerException("mobNo-" +
		 * mobNo); }
		 * 
		 * List<CustomerDetails> list = new ArrayList<>();
		 * 
		 * CustomerDetails details=new CustomerDetails();
		 * 
		 * details.setCustomerName("custname");
		 * details.setAadharNumber("1436543");
		 * details.setPanCardNumber("CVDLY4563E");
		 * 
		 * 
		 * Accounts account=new Accounts();
		 * 
		 * account.setId(2536L); account.setCustomerAccountName("custName");
		 * account.setAccountNumber("DFG121154"); account.setBankName("BOI");
		 * account.setAccountStatus("Active"); account.setAccountType("Saving");
		 * account.setBranchName("Pune"); account.setBranchId("DFGH1254");
		 * account.setIfsc("PSFG");
		 * 
		 * 
		 * Set<Accounts> banklist=new HashSet<Accounts>();
		 * banklist.add(account);
		 * 
		 * details.setAccountsInfo(banklist);
		 * 
		 * list.add(details);
		 * 
		 * return list;
		 */

		List<CustomerDetails> list = new ArrayList<>();

		list = customerDetailsReopsitory.findAll();

		System.out.println("Size : " + list.get(0).getAccountsInfo().size());

		return list;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String login() {

		System.out.println("Welcome called Login");

		return "welcome";

	}

}
