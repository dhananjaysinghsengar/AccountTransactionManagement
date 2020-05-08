package com.account;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.account.controller.AccountController;
import com.account.model.AccountInformation;
import com.account.model.AccountTransactionHistory;
import com.account.service.impl.AccountService;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class)
public class AccountManagementApplicationTests {

	private AccountController accountController;

	@MockBean
	private AccountService mockAccountService;

	@Before
	public void startBefore() {
		accountController = new AccountController(mockAccountService);

	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAccountListEnquiryTest() throws Exception {

		AccountInformation accountDetail = ModelHelper.fromJson("AccountDetail.json", AccountInformation.class);

		given(mockAccountService.retrieveAllAccountDetail()).willReturn(accountDetail);
		ResponseEntity<AccountInformation> responseEntity = accountController.getAccountListEnquiry();

		assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.OK));
		assertThat(responseEntity.getBody(), Is.is(accountDetail));

	}
	
	@Test
	public void getAccountListEnquiryTestFailed() throws Exception {

		AccountInformation accountDetail = null;

		given(mockAccountService.retrieveAllAccountDetail()).willReturn(null);
		ResponseEntity<AccountInformation> responseEntity = accountController.getAccountListEnquiry();

		assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.NOT_FOUND));
		assertThat(responseEntity.getBody(), Is.is(accountDetail));

	}
	
	@Test
	public void getAccountTransactionHistoryTest() throws Exception {

		AccountTransactionHistory accountDetail = ModelHelper.fromJson("AccountTransactionHistory_585309209.json", AccountTransactionHistory.class);
		given(mockAccountService.retrieveAccountTransactionHistory("585309209")).willReturn(accountDetail);
		ResponseEntity<AccountTransactionHistory> responseEntity = accountController.getAccountTransactionHistory("585309209");

		assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.OK));
		assertThat(responseEntity.getBody(), Is.is(accountDetail));

	}
	
	
	@Test
	public void getAccountTransactionHistoryTestFailed() throws Exception {
		AccountTransactionHistory accountDetail = null;
		given(mockAccountService.retrieveAccountTransactionHistory("585309209")).willReturn(null);
		ResponseEntity<AccountTransactionHistory> responseEntity = accountController.getAccountTransactionHistory("585309209");

		assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.NOT_FOUND));
		assertThat(responseEntity.getBody(), Is.is(accountDetail));

	}

}
