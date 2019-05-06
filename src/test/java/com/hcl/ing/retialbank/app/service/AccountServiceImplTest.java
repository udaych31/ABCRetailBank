package com.hcl.ing.retialbank.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.retialbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retialbank.app.dto.AccountUpdateRequest;
import com.hcl.ing.retialbank.app.dto.AccountUpdateResponse;
import com.hcl.ing.retialbank.app.dto.AddPayeeReference;
import com.hcl.ing.retialbank.app.dto.ManagePayeeDto;
import com.hcl.ing.retialbank.app.dto.OtpRequest;
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.entity.ManagePayee;
import com.hcl.ing.retialbank.app.entity.OtpDetails;
import com.hcl.ing.retialbank.app.entity.TempPayee;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.OtpRepository;
import com.hcl.ing.retialbank.app.repository.PayeeRepository;
import com.hcl.ing.retialbank.app.repository.TempPayeeRepository;
import com.hcl.ing.retialbank.app.util.EmailSender;


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
	
	@InjectMocks
	private AddPayeeServiceImpl addPayeeServiceImpl;
	
	@Mock
	TempPayeeRepository tempPayeeRepository;
	@Mock
	private OtpRepository otpRepository;
	
	@Mock
	private EmailSender emailSender;
	
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
		
		List<ManagePayeeDto> list=new ArrayList<ManagePayeeDto>();		
		ManagePayeeDto dto=new ManagePayeeDto();
		dto.setPayeeId(2L);
		dto.setAccountNo(12L);
		dto.setPayeeAccountNo(1234L);
		dto.setPayeeName("Hari");
		dto.setNickName("priya");				
		list.add(dto);		
		
		List<ManagePayee> managePayeeLists=new ArrayList<ManagePayee>();
		ManagePayee managePayee=new ManagePayee();
		managePayee.setPayeeId(2L);
		managePayee.setAccountNo(12L);
		managePayee.setPayeeAccountNo(1234L);
		managePayee.setPayeeName("Hari");
		managePayee.setNickName("priya");		
		managePayeeLists.add(managePayee);
		
		when(payeeRepository.findByAccountNo(1234L)).thenReturn(managePayeeLists);
		 List<ManagePayeeDto> payesList = payeeServiceImpl.getPayeesList(1234L);
		assertEquals(list.size(), payesList.size());
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAddPayee() {
		
		AccountSummary account=new AccountSummary();
		account.setAccountNo(1234L);
		account.setEmail("madhurya.suma@gmail.com");
		
		OtpDetails request=new OtpDetails();
		request.setAccountNo(1L);
		
		OtpRequest otp=new OtpRequest();
		otp.setAccountNo(1L);
		TempPayee managePayee = new TempPayee();
		managePayee.setPayeeId(1L);
		
		ManagePayeeDto payee=new ManagePayeeDto();
		payee.setAccountNo(1234L);
		payee.setNickName("suma");
		payee.setPayeeAccountNo(123L);
		payee.setPayeeName("karna");
		
		
		Mockito.when(accountRepository.findByAccountNo(payee.getAccountNo())).thenReturn(account);
		Mockito.when(otpRepository.findByAccountNo(otp.getAccountNo())).thenReturn(request);
		Mockito.when(tempPayeeRepository.save(managePayee)).thenReturn(managePayee);
		
		
		AddPayeeReference reference =addPayeeServiceImpl.addPayee(payee);
		Assert.assertEquals("OTP send successfully .. ! Use this reference no for adding payee..!", reference.getMessage());
		 
		
		
	}

}
