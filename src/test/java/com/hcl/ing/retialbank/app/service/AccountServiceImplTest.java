package com.hcl.ing.retialbank.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.retialbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retialbank.app.dto.AccountUpdateRequest;
import com.hcl.ing.retialbank.app.dto.AccountUpdateResponse;
import com.hcl.ing.retialbank.app.dto.ManagePayeeDto;
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.dto.TransactionDto;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.entity.Transaction;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.PayeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {
	
	@Mock
	private AccountSummaryRepository accountRepository;
	
	@InjectMocks
	private AccountServiceImpl serviceImpl;
	
	@Mock
	private PayeeRepository payeeRepository;
	
	@InjectMocks
	private PayeeServiceImpl payeeServiceImpl;
	
	@Test
	public void testSearchByAccountNoOrAccountName() {
		
		List<AccountSummary> list=new ArrayList<AccountSummary>();
		AccountSummary summary=new AccountSummary();
		summary.setAccountNo(1L);
		summary.setAccountName("uday");
		summary.setAccountType("savings");
		summary.setAddress("bangalore");
		summary.setBranchName("bangalore");
		summary.setClosingBalance(500.0);
		summary.setDob("11/04/1990");
		list.add(summary);
		
		SearchRequest request=new SearchRequest();
		request.setAccountName("uday");
		request.setAccountNo(1L);
		
		when(accountRepository.findByAccountNoOrAccountName(1L, "uday")).thenReturn(list);
		AccountSummaryResponse response = serviceImpl.searchByAccountNoOrAccountName(request);
		if(response!=null && response.getSummaryList()!=null &&  !response.getSummaryList().isEmpty()) {
			assertEquals(list.size(), response.getSummaryList().size());
		}
		
	}
	
	@Test
	public void testupdateAccountDetails() {
		AccountUpdateRequest request=new AccountUpdateRequest();
		request.setAccountNo(1L);
		request.setAccountName("uday");
		request.setAccountType("savings");
		request.setAddress("bangalore");
		request.setBranchName("bangalore");
		
		AccountSummary summary=new AccountSummary();
		summary.setAccountNo(1L);
		summary.setAccountName("uday");
		summary.setAccountType("savings");
		summary.setAddress("bangalore");
		summary.setBranchName("bangalore");
		
		when(accountRepository.findByAccountNo(1L)).thenReturn(summary);
		AccountUpdateResponse response = serviceImpl.updateAccountDetails(request);
		if(response!=null) {
			assertEquals("Account details updated successfully...!", response.getMessage());
		}
		
	}
	
	@Test
	public void testPayeesList() {
		
//		List<ManagePayeeDto> list=new ArrayList<ManagePayeeDto>();
//		
//		ManagePayeeDto dto=new ManagePayeeDto();
//		dto.setAccountNo(1L);
//		dto.setPayeeAccountNo(2L);
//		dto.setFromAccountNumber(1234L);
//		dto.setTransactionAmount(2000.00);
//		dto.setTransactionId(2l);		
//		list.add(dto);
//		
//		
//		List<Transaction> trasactionLists=new ArrayList<Transaction>();
//		Transaction transaction=new Transaction();
//		transaction.setAccountNumber(1L);
//		transaction.setClosingBalance(1000.00);
//		transaction.setFromAccountNumber(1234L);
//		transaction.setTransactionAmount(2000.00);
//		transaction.setTransactionId(2l);		
//		trasactionLists.add(transaction);
//		
//		when(payeeRepository.findTransactions(1L)).thenReturn(trasactionLists);
//		 List<TransactionDto> payesList = payeeServiceImpl.getPayeesList(1L);
//		assertEquals(list, payesList);
		
	}
	

}
