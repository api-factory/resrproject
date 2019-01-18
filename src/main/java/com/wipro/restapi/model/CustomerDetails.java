package com.wipro.restapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="customer_id")
	private Long id;
	@Column
	private String customerName;
	@Column
	private String panCardNumber;
	@Column
	private String aadharNumber;
	@Column
	private String mobileNumber;


	@JsonManagedReference
    @OneToMany(mappedBy="customer")
	private Set<Accounts> accountsInfo = new HashSet();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	
	public Set<Accounts> getAccountsInfo() {
		return accountsInfo;
	}

	public void setAccountsInfo(Set<Accounts> accountsInfo) {
		this.accountsInfo = accountsInfo;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerName=" + customerName + ", panCardNumber=" + panCardNumber + ", aadharNumber="
				+ aadharNumber + ", accountsInfo=" + accountsInfo + "]";
	}

}
