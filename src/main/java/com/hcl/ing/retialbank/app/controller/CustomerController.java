package com.hcl.ing.retialbank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retialbank.app.dto.CustomerResponse;
import com.hcl.ing.retialbank.app.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customerOrAdminLogin")
	public ResponseEntity<String> custOrAdminLogin(@RequestParam String userName,@RequestParam String password)
	{
		CustomerResponse customerResponse=customerService.loginUser(userName, password);
		return new ResponseEntity<String>(customerResponse.getResponse(),HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/changePassword")
	public ResponseEntity<String> changePassword(@RequestParam String userName,@RequestParam String password)
	{
		CustomerResponse customerResponse=customerService.changePassword(userName, password);
		return new ResponseEntity<String>(customerResponse.getResponse(),HttpStatus.CREATED);
		
	}

}
