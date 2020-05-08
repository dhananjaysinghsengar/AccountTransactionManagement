package com.account.model;

/**
 * @author Dhananjay Singh Sengar Customer detail model to list account enquiry.
 */
public class AccountDetail {

	int accountNumber;
	String accountName;
	String accountType;
	String balanceDate;
	String currency;
	float openingAvailableBalance;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(float openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}

}
