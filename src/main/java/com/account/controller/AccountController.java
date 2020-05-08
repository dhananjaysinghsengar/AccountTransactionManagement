package com.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.account.model.AccountInformation;
import com.account.model.AccountTransactionHistory;
import com.account.service.impl.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


/**
 * @author Dhananjay Singh Sengar.
 * Rest controller to enquire about all customer.
 * and.
 * enlist complete transaction history for an account.
 *
 */
@RestController
@RequestMapping("/v1")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	private AccountService accountService;

	@Autowired
	public AccountController(final AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * Get method controller to list complete list.
	 * of accounts.
	 * @return
	 */
	@GetMapping(path = "/getAllAccountDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountInformation> getAccountListEnquiry() {
		try {
			logger.info("Inside getAll method");
			final AccountInformation accountDetail = accountService.retrieveAllAccountDetail();
			if (accountDetail == null) {
				logger.info("unable to retrieve account details");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(accountDetail, HttpStatus.OK);
		} catch(Exception e) {
			logger.info("Error while processing the request: "+ e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Enlist transaction history based on the provided account name
	 * @param accountNumber
	 * @return
	 */
	@GetMapping(path = "/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountTransactionHistory> getAccountTransactionHistory(
			@PathVariable("accountNumber") final String accountNumber) {
		try {
			logger.info("Inside getTransactionHistory method for account {}", accountNumber);
			final AccountTransactionHistory accountDetail = accountService
					.retrieveAccountTransactionHistory(accountNumber);
			if (accountDetail == null) {
				logger.info("unable to retrieve customer details");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(accountDetail, HttpStatus.OK);
		} catch(Exception e) {
			logger.info("Error while processing the request: "+ e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
