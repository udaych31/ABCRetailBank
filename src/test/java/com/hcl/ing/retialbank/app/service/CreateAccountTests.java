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
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.CustomerRepository;
import com.hcl.ing.retialbank.app.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTests {
	
	
	@Mock
	AccountSummaryRepository accoutRespository;
	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerServiceImpl customerService;
	

	
	
	
	@Test
	public void testCreateAccount() {
		
		/*CustomerDTO customerDto=new CustomerDTO();
		
		AccountSummary accountInfo=new AccountSummary();
		
		
		accountInfo.setAccountName("suma");
		accountInfo.setClosingBalance(3000.0);
		accountInfo.setAccountName("karna");
		accountInfo.setAccountType("savingsAcc");
		accountInfo.setAddress("Bangalore");
		accountInfo.setBranchName("Ecbranch");
		accountInfo.setClosingBalance(20.0);
		accountInfo.setDob("14-12-1990");
		accountInfo.setRole("Admin");
		//accountInfo.setAccountNo(1234L);
		
		AccountSummary accountInfo1=new AccountSummary();
		
		
		accountInfo1.setAccountNo(1234L);
		accountInfo1.setAccountName("suma");
		accountInfo1.setClosingBalance(3000.0);
		
		
		CustomerInfo customerinfo=new CustomerInfo();
		customerinfo.setUserName("karnasder");
		customerinfo.setPassword("Ecbranch5645324");
		
		customerDto.setAccountName("karna");
		customerDto.setAccountType("savingsAcc");
		customerDto.setAddress("Bangalore");
		customerDto.setBranchName("Ecbranch");
		customerDto.setClosingBalance(20.0);
		customerDto.setDob("14-12-1990");
		customerDto.setRole("Admin");
		customerDto.setAccountNo(1234L);
		
		Mockito.when(accoutRespository.save(accountInfo)).thenReturn(accountInfo1);
		
		//Mockito.when(customerRepository.save(customerinfo)).thenReturn(customerinfo);
		 
		UserResponse response=customerService.createAccount(customerDto);
		
		
		Assert.assertEquals(customerinfo.getUserName(), response.getUserName());
	
		Assert.assertEquals(customerinfo.getPassword(), response.getPassword());
		
		*/
		
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
	
	
	
	
	
	
	


