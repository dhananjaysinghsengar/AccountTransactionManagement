package com.account.service.impl;

import com.account.model.*;


/**
 * @author Dhananjay Singh Sengar
 * Interface for service layer.
 */
public interface AccountService {
	
	AccountInformation retrieveAllAccountDetail();
	AccountTransactionHistory retrieveAccountTransactionHistory(String accountNumber);

}
