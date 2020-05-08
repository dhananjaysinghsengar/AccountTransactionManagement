package com.account.model;

import java.util.List;

/**
 * @author dhananjay.sengar Model for Customer Detail to consolidate multiple
 *         json object.
 */
public class AccountInformation {

	List<AccountDetail> customerDetail;

	public List<AccountDetail> getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(List<AccountDetail> customerDetail) {
		this.customerDetail = customerDetail;
	}

}
