package com.hcl.ing.retialbank.app.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.retialbank.app.dto.CustomerResponse;
import com.hcl.ing.retialbank.app.entity.CustomerInfo;
import com.hcl.ing.retialbank.app.repository.CustomerRepository;




@RunWith(MockitoJUnitRunner.class)
public class CustomerLoginAppTest {
	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Test
	public void testLoginUser() {
		
		List<CustomerInfo> customerLists=new ArrayList<CustomerInfo>();
		
		CustomerInfo customerInfo=new CustomerInfo();
		
		customerInfo.setUserName("Hari");
		customerInfo.setPassword("priya");
		customerLists.add(customerInfo);
		
		Mockito.when(customerRepository.findAll()).thenReturn(customerLists);
		
		CustomerResponse response=customerServiceImpl.loginUser("Hari","priya");
		
		
	   Assert.assertEquals("Logined successfully", response.getResponse());
	
	
	} 
	
	
	@Test
	public void testChangePassword() {
		
		
		CustomerInfo customerInfo=new CustomerInfo();
		customerInfo.setUserName("Hari");
		customerInfo.setPassword("priya");
		customerInfo.setCustomerAccess('T');
		
		Mockito.when(customerRepository.getUserInfo("Hari")).thenReturn(customerInfo);
		Mockito.when(customerRepository.save(customerInfo)).thenReturn(customerInfo);
		
		CustomerResponse response = customerServiceImpl.changePassword("Hari", "priya");
		assertEquals("Password changed successfully", response.getResponse());
		
		
	}

}
