package com.account.service.impl;

import com.account.*;
import com.account.controller.AccountController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.account.model.AccountInformation;
import com.account.model.AccountTransactionHistory;

/**
 * @author dhananjay.sengar 
 * Service layer implementation for functionalities.
 */
@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	/**
	 * 
	 * Method implementation to list all. ModelHelper is used for data simulation.
	 * through json files placed in resources.
	 */
	@Override
	public AccountInformation retrieveAllAccountDetail() {
		logger.info("inside retrieveAllCustomerDetail");
		AccountInformation customerDetail = ModelHelper.fromJson("AccountDetail.json", AccountInformation.class);
		return customerDetail;
	}

	/**
	 * Method implementation to list transaction history. for an. account. Model
	 * Helper is used for data simulation. through json files placed in resource.
	 * the key for query is Account Number and is suffixed. in json files.
	 */
	@Override
	public AccountTransactionHistory retrieveAccountTransactionHistory(String accountName) {
		AccountTransactionHistory customerTransactionDetail = ModelHelper
				.fromJson("AccountTransactionHistory_" + accountName + ".json", AccountTransactionHistory.class);
		return customerTransactionDetail;
	}

}
