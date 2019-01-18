package com.wipro.restapi.model;

/*@Entity
@Table(name = "users")*/
public class AccountBalance {
	
	private String balance;

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountBalance [balance=" + balance + "]";
	}
	
	

}
