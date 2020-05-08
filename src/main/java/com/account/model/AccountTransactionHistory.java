package com.account.model;

import java.util.List;

/**
 * @author dhananjay.sengar Customer Transaction history model to consolidate
 *         multiple json objects.
 */
public class AccountTransactionHistory {

	List<AccountTransactionDetail> customerTransactionHistory;

	public List<AccountTransactionDetail> getCustomerTransactionHistory() {
		return customerTransactionHistory;
	}

	public void setCustomerTransactionHistory(List<AccountTransactionDetail> customerTransactionHistory) {
		this.customerTransactionHistory = customerTransactionHistory;
	}

}
