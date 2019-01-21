package com.wipro.restapi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/accountdetails")
	public CustomerDetails getBankDetails(@RequestHeader(value = "mobilenumber") String mobNo) {
		if (mobNo.isEmpty()) {
			throw new InternalServerException("mobile number-" + mobNo);
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

	@RequestMapping("/checkaccountbalance")
	public AccountBalance checkAccountBalance(@RequestHeader(value = "mobilenumber") String mobNo,
			@RequestHeader(value = "accountnumber") String accountNo) {

		if (mobNo.isEmpty()) {
			throw new InternalServerException("mobNo-" + mobNo);
		} else if (accountNo.isEmpty()) {
			throw new InternalServerException("accountNo-" + accountNo);
		}

		AccountBalance balanceInfo = new AccountBalance();

		balanceInfo.setBalance("212454");

		return balanceInfo;
	}

	@RequestMapping("/customeraccountlist")
	@Secured("USER")
	public List<CustomerDetails> getBankDetailList(@RequestHeader(value = "mobilenumber") String mobNo) {
		List<CustomerDetails> list = new ArrayList<>();

		list = customerDetailsReopsitory.findAll();

		System.out.println("Size : " + list.get(0).getAccountsInfo().size());

		return list;
	}
	
	@RequestMapping("/customeraccounts")
	@Secured("USER")
	public List<CustomerDetails> getBankDetailListByPhone(@RequestHeader(value = "mobilenumber") String mobNo) {
		

		List<CustomerDetails> list = new ArrayList<>();

		list = customerDetailsReopsitory.findAll();
		
		List<CustomerDetails> predicate = list.stream().filter(mno -> mno.getMobileNumber().equals(mobNo)).collect(Collectors.toList());

		return predicate;
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String login() {

		System.out.println("Welcome called Login");

		return "welcome";

	}*/

}
