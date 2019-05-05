package com.hcl.ing.retialbank.app.service;

import com.hcl.ing.retialbank.app.dto.TransactionResponse;
import com.hcl.ing.retialbank.app.entity.Transaction;
import com.hcl.ing.retialbank.app.pojo.TransactionPojo;

public interface TransactionService {

	public TransactionResponse transaction(TransactionPojo transaction);
	
}
