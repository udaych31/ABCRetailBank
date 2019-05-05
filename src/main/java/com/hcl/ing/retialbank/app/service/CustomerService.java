package com.hcl.ing.retialbank.app.service;

import com.hcl.ing.retialbank.app.dto.AccountResponse;
import com.hcl.ing.retialbank.app.dto.CustomerDTO;
import com.hcl.ing.retialbank.app.dto.CustomerResponse;
import com.hcl.ing.retialbank.app.dto.UserResponse;

public interface CustomerService {

	public CustomerResponse loginUser(String username,String password);
	
	public CustomerResponse changePassword(String customerId,String password);

	public UserResponse createAccount(CustomerDTO customerDto);
	
	public AccountResponse accountDetails(String userName);

}
