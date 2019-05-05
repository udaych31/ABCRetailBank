package com.hcl.ing.retialbank.app.service;

import com.hcl.ing.retialbank.app.dto.TransactionResponse;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.entity.Transaction;
import com.hcl.ing.retialbank.app.pojo.TransactionPojo;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.TransactionRepository;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountSummaryRepository accountSummary;
	@Autowired
	TransactionRepository transactionRepository;

	public TransactionResponse transaction(TransactionPojo transactionPojo) {

		TransactionResponse response = new TransactionResponse();

		Transaction transaction = new Transaction();
		transaction.setAccountNumber(transactionPojo.getAccountNumber());
		transaction.setTransactionType(transactionPojo.getTransactionType());
		transaction.setFromAccountNumber(transactionPojo.getFromAccountNumber());
		transaction.setTransactionAmount(transactionPojo.getTransactionAmount());
		transaction.setTransactionRemarks(transactionPojo.getTransactionRemarks());
		transaction.setTransactionDate(new Date());
		AccountSummary account = accountSummary.findByAccountNo(transaction.getAccountNumber());
		if (transactionPojo.getTransactionType().equals("debit")) {
			if (transactionPojo.getTransactionAmount() < account.getClosingBalance()) {
				account.setClosingBalance(account.getClosingBalance()-transactionPojo.getTransactionAmount());
				response.setMessage("amount debited successfully");
				
			} else {
				response.setMessage("no minimum balance");
				
		
			}
		} else if(transactionPojo.getTransactionType().equals("credit")){
			account.setClosingBalance(transactionPojo.getTransactionAmount() + account.getClosingBalance());
			response.setMessage("amount credited successfully");
			
		}
		transaction.setClosingBalance(account.getClosingBalance());
		
		transactionRepository.save(transaction);
		accountSummary.save(account);
		return response;
	}

}
