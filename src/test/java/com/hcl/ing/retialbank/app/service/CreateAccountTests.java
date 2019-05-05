package com.hcl.ing.retialbank.app.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.retialbank.app.dto.AccountResponse;
import com.hcl.ing.retialbank.app.dto.CustomerDTO;
import com.hcl.ing.retialbank.app.dto.UserResponse;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.entity.CustomerInfo;
import com.hcl.ing.retialbank.app.entity.Transaction;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.CustomerRepository;


@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTests {
	
	
	@Mock
	AccountSummaryRepository accoutRespository;

	@Mock
	 CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerServiceImpl customerService;
	

	
	
	
	//@Test
	public void testCreateAccount() {
		
		CustomerDTO dto=new CustomerDTO();
		UserResponse response=new UserResponse();
		Transaction transaction=new Transaction();
		
		
		AccountSummary createAcct=new AccountSummary();
		
		createAcct.setAccountNo(1234L);
		
		dto.setAccountName("suma");
		dto.setAccountType("savings");
		dto.setAddress("Bangalore");
		dto.setBranchName("HDFC");
		dto.setClosingBalance(50000.0);
		dto.setDob("12-02-1989");
		dto.setEmailId("suma@gmail.com");
		dto.setRole("customer");
		
		Mockito.when(accoutRespository.save(createAcct)).thenReturn(createAcct);
	//	Mockito.when(transationRepository.save(transaction)).thenReturn(transaction);
		response=customerService.createAccount(dto);
		Assert.assertEquals("sumasder", response.getUserName());
		Assert.assertEquals("HDFC5645324", response.getPassword());
		
		
	}
	
	
	@Test
	public void testAccountDetails() {
		   
	   AccountSummary account=new AccountSummary();
	   
	    account.setClosingBalance(1234.0);
	    
	    CustomerInfo info=new CustomerInfo();
	    info.setAccno(1234L);;
	
		Mockito.when(customerRepository.findByUserName("suma")).thenReturn(info);
		
		Mockito.when(accoutRespository.findByAccountNo(1234L)).thenReturn(account);;
		
		AccountResponse accresponse=customerService.accountDetails("suma");
		
	   Assert.assertEquals(info.getAccno(), accresponse.getAccNo());
		
	   Assert.assertEquals(account.getClosingBalance(), accresponse.getBalance());
		
	}

	
	}
	
	
	
	
	
	
	


