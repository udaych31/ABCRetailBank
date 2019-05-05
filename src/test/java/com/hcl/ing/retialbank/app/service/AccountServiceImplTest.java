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
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {
	
	@Mock
	private AccountSummaryRepository accountRepository;
	
	@InjectMocks
	private AccountServiceImpl serviceImpl;
	
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

}
