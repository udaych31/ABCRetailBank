package com.hcl.ing.retialbank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retialbank.app.dto.TransactionResponse;
import com.hcl.ing.retialbank.app.pojo.TransactionPojo;
import com.hcl.ing.retialbank.app.service.TransactionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
public class TransactionController {

	@Autowired
	TransactionService transactionservice;
	@PostMapping("/transaction")
	@ApiOperation(
			value = "Create the transaction",
		    notes = "If it is success it returns ammount debited or credited successfull message or else no insufficient fund")	
	public TransactionResponse transaction(@RequestBody TransactionPojo transaction)
	{
		return transactionservice.transaction(transaction);
		
	}
	
}
