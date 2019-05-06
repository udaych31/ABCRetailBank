package com.hcl.ing.retialbank.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.retialbank.app.dto.AccountSummaryDto;
import com.hcl.ing.retialbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retialbank.app.dto.AccountUpdateRequest;
import com.hcl.ing.retialbank.app.dto.AccountUpdateResponse;
import com.hcl.ing.retialbank.app.dto.DeletePayeeConfirm;
import com.hcl.ing.retialbank.app.dto.DeleteResponse;
import com.hcl.ing.retialbank.app.dto.OtpRequest;
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.dto.TransactionDto;
import com.hcl.ing.retialbank.app.dto.ValidateOtpRequest;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.entity.ManagePayee;
import com.hcl.ing.retialbank.app.entity.OtpDetails;
import com.hcl.ing.retialbank.app.entity.TempPayee;
import com.hcl.ing.retialbank.app.entity.Transaction;
import com.hcl.ing.retialbank.app.pojo.ManagePayeePojo;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.CustomerRepository;
import com.hcl.ing.retialbank.app.repository.ManagePayeeRepository;
import com.hcl.ing.retialbank.app.repository.OtpRepository;
import com.hcl.ing.retialbank.app.repository.TransactionRepository;
import com.hcl.ing.retialbank.app.util.EmailSender;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountSummaryRepository accountSummaryRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	ManagePayeeRepository managePayeeRepository;
	
	@Autowired	
	OtpRepository otpRepository;
	
	@Override
	public AccountSummaryResponse searchByAccountNoOrAccountName(SearchRequest request) {
		AccountSummaryResponse response = new AccountSummaryResponse();
		try {

			List<AccountSummary> listOfAcc = accountSummaryRepository
					.findByAccountNoOrAccountName(request.getAccountNo(), request.getAccountName());
			List<AccountSummaryDto> dtoList = new ArrayList<>();
			if (!listOfAcc.isEmpty()) {
				listOfAcc.stream().forEach(account -> {
					AccountSummaryDto dto = new AccountSummaryDto();
					dto.setAccountNo(account.getAccountNo());
					dto.setAccountName(account.getAccountName());
					dto.setAccountType(account.getAccountType());
					dto.setAddress(account.getAddress());
					dto.setBranchName(account.getBranchName());
					dto.setClosingBalance(account.getClosingBalance());
					dto.setDob(account.getDob());
					dto.setCreateDt(account.getCreateDt());
					dtoList.add(dto);
					response.setSummaryList(dtoList);
				});
			}

		} catch (Exception e) {
		}
		return response;
	}

	@Override
	public AccountUpdateResponse updateAccountDetails(AccountUpdateRequest request) {
		AccountUpdateResponse response = new AccountUpdateResponse();
		try {

			if (request != null) {
				AccountSummary summary = getAccountSummary(request.getAccountNo());
				if (summary != null) {
					summary.setAccountName(request.getAccountName());
					summary.setAccountNo(request.getAccountNo());
					summary.setAccountType(request.getAccountType());
					summary.setAddress(request.getAddress());
					summary.setBranchName(request.getBranchName());
					summary.setDob(request.getDob());
					accountSummaryRepository.save(summary);
					response.setMessage("Account details updated successfully...!");
				} else {
					response.setMessage("Account is not available , please create an account");
				}
			}

		} catch (Exception e) {

		}
		return response;
	}

	private AccountSummary getAccountSummary(Long accoutNo) {
		AccountSummary summary = null;
		try {
			summary = accountSummaryRepository.findByAccountNo(accoutNo);
		} catch (Exception e) {

		}
		return summary;
	}

	@Override
	public List<TransactionDto> getRecentTransaction(Long accountNo) {
		List<TransactionDto> response = new ArrayList<>();
		try {
			List<Transaction> list = transactionRepository.findByAccountNumberOrderByTransactionDateDesc(accountNo);
			if (!list.isEmpty()) {
				list.stream().forEach(transaction -> {
					TransactionDto dto = new TransactionDto();
					dto.setAccountNumber(transaction.getAccountNumber());
					dto.setClosingBalance(transaction.getClosingBalance());
					dto.setFromAccountNumber(transaction.getFromAccountNumber());
					dto.setTransactionAmount(transaction.getTransactionAmount());
					dto.setTransactionDate(transaction.getTransactionDate());
					dto.setTransactionId(transaction.getTransactionId());
					dto.setTransactionRemarks(transaction.getTransactionRemarks());
					dto.setTransactionType(transaction.getTransactionType());
					response.add(dto);
				});
			}

		} catch (Exception e) {

		}
		return response;
	}

	@Override
	public boolean sendOtp(OtpRequest request) {
		try {
			emailSender.sendOtp(request);
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	public DeleteResponse deletepayee(ManagePayeePojo managePayeePojo) {

		DeleteResponse deleteResponse = new DeleteResponse();
		ManagePayee managePayeeToBeDeleted = managePayeeRepository.findByPayeeAccountNo(managePayeePojo.getPayeeAccountNo());
		AccountSummary account = accountSummaryRepository.findByAccountNo(managePayeePojo.getAccountNo());
		
		if(managePayeeToBeDeleted!=null && account!=null) {
			OtpRequest request=new OtpRequest();
			request.setAccountNo(managePayeePojo.getAccountNo());
			request.setEmail(account.getEmail());
			boolean sendOtp = sendOtp(request);
			if(sendOtp) {
				deleteResponse.setMessage("OTP send successfully .. !");
			}else {
				deleteResponse.setMessage("Some thing wrong please try again .. !");
			}
		}else {
			deleteResponse.setMessage("Account/Payee does not exist .. !");
		}
		return deleteResponse;
		
	}
	
	@Override
	public OtpDetails validateOtp(ValidateOtpRequest request) {
		OtpDetails otp=null;
		try {
			otp = otpRepository.findByAccountNo(request.getAccountNo());
			if(otp!=null && otp.getOtp().longValue()==request.getOtp().longValue()) {
				return otp;
			}
		} catch (Exception e) {
		}
		return otp;

	}

	public DeleteResponse deletePayeeConfirm(DeletePayeeConfirm deletePayeeConfirm) {

		DeleteResponse deleteResponse = new DeleteResponse();
		
		ValidateOtpRequest request=new ValidateOtpRequest();
		request.setAccountNo(deletePayeeConfirm.getAccountNo());
		request.setOtp(deletePayeeConfirm.getOtp());
		OtpDetails validateOtp = validateOtp(request);
		if(validateOtp!=null) {
			boolean managePayeeToBeDeleted = managePayeeRepository.deleteByPayeeId(deletePayeeConfirm.getPayeeId());
			if(managePayeeToBeDeleted) {
				deleteResponse.setMessage("Payee deleted successfully ...!");
			}else {
				deleteResponse.setMessage("Payee not deleted successfully ...!");
			}
			
		}else {
			deleteResponse.setMessage("OTP is invalid ...!");
		}
		
		
		return deleteResponse;
	}
	
}
