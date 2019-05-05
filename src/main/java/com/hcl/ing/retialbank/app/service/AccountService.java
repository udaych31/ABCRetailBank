package com.hcl.ing.retialbank.app.service;

import java.util.List;

import com.hcl.ing.retialbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retialbank.app.dto.AccountUpdateRequest;
import com.hcl.ing.retialbank.app.dto.AccountUpdateResponse;
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.dto.TransactionDto;

public interface AccountService {
	
	public AccountSummaryResponse searchByAccountNoOrAccountName(SearchRequest request);
	
	public AccountUpdateResponse updateAccountDetails(AccountUpdateRequest request);
	
	public List<TransactionDto> getRecentTransaction(Long accountNo);
	
	

}
