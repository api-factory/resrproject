package com.wipro.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "account_details")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String bankName;
	@Column
	private String accountNumber;
	@Column
	private String customerAccountName;
	@Column
	private String accountType;
	@Column
	private String branchId;
	@Column
	private String branchName;
	@Column
	private String accountStatus;
	@Column
	private String ifsc;
	@Column
	private String balance;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerDetails customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerAccountName() {
		return customerAccountName;
	}

	public void setCustomerAccountName(String customerAccountName) {
		this.customerAccountName = customerAccountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

}
