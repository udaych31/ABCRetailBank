package com.hcl.ing.retialbank.app.service;

import java.util.List;

import com.hcl.ing.retialbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retialbank.app.dto.AccountUpdateRequest;
import com.hcl.ing.retialbank.app.dto.AccountUpdateResponse;
import com.hcl.ing.retialbank.app.dto.DeletePayeeConfirm;
import com.hcl.ing.retialbank.app.dto.DeleteResponse;
import com.hcl.ing.retialbank.app.dto.OtpRequest;
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.dto.TransactionDto;

import com.hcl.ing.retialbank.app.pojo.ManagePayeePojo;

import com.hcl.ing.retialbank.app.dto.ValidateOtpRequest;
import com.hcl.ing.retialbank.app.entity.OtpDetails;


public interface AccountService {

	public AccountSummaryResponse searchByAccountNoOrAccountName(SearchRequest request);

	public AccountUpdateResponse updateAccountDetails(AccountUpdateRequest request);

	public List<TransactionDto> getRecentTransaction(Long accountNo);


	public DeleteResponse deletepayee(ManagePayeePojo managePayeePojo);

	
	public boolean sendOtp(OtpRequest request);
	
	public OtpDetails validateOtp(ValidateOtpRequest otp);
	
	public DeleteResponse deletePayeeConfirm(DeletePayeeConfirm deletePayeeConfirm);
	


}
