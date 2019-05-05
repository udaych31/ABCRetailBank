package com.hcl.ing.retialbank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retialbank.app.dto.TransactionResponse;
import com.hcl.ing.retialbank.app.entity.Transaction;
import com.hcl.ing.retialbank.app.pojo.TransactionPojo;
import com.hcl.ing.retialbank.app.service.TransactionService;

@RestController
@RequestMapping("/")
public class TransactionController {

	@Autowired
	TransactionService transactionservice;
	@PostMapping("/transaction")
	public TransactionResponse transaction(@RequestBody TransactionPojo transaction)
	{
		return transactionservice.transaction(transaction);
		
	}
	
}
