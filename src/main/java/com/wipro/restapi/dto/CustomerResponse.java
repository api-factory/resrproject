package com.wipro.restapi.dto;

import java.util.ArrayList;
import java.util.List;

import com.wipro.restapi.model.Accounts;

public class CustomerResponse {

	private Long id;
	private String customerName;
	private String panCardNumber;
	private String aadharNumber;
	private String mobileNumber;
	private List<Accounts> accountsInfo = new ArrayList<Accounts>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPanCardNumber() {
		return panCardNumber;
	}
	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public List<Accounts> getAccountsInfo() {
		return accountsInfo;
	}
	public void setAccountsInfo(List<Accounts> accountsInfo) {
		this.accountsInfo = accountsInfo;
	}
	
	
}
