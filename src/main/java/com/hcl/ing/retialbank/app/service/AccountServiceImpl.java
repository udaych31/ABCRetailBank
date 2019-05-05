package com.hcl.ing.retialbank.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.retialbank.app.dto.AccountSummaryDto;
import com.hcl.ing.retialbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retialbank.app.dto.AccountUpdateRequest;
import com.hcl.ing.retialbank.app.dto.AccountUpdateResponse;
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.dto.TransactionDto;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.entity.Transaction;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.CustomerRepository;
import com.hcl.ing.retialbank.app.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountSummaryRepository accountSummaryRepository; 
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	

	@Override
	public AccountSummaryResponse searchByAccountNoOrAccountName(SearchRequest request) {
		AccountSummaryResponse response=new AccountSummaryResponse();
		try {
			
			List<AccountSummary> listOfAcc = accountSummaryRepository.findByAccountNoOrAccountName(request.getAccountNo(), request.getAccountName());
			List<AccountSummaryDto> dtoList=new ArrayList<>();
			if(!listOfAcc.isEmpty()) {
				listOfAcc.stream().forEach(account ->{
					AccountSummaryDto dto=new AccountSummaryDto();
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
		AccountUpdateResponse response=new AccountUpdateResponse();
		try {
			
			if(request!=null) {
				AccountSummary summary = getAccountSummary(request.getAccountNo());
				if(summary!=null) {
					summary.setAccountName(request.getAccountName());
					summary.setAccountNo(request.getAccountNo());
					summary.setAccountType(request.getAccountType());
					summary.setAddress(request.getAddress());
					summary.setBranchName(request.getBranchName());
					summary.setDob(request.getDob());
					accountSummaryRepository.save(summary);
					response.setMessage("Account details updated successfully...!");
				}else {
					response.setMessage("Account is not available , please create an account");
				}
			}
			
			
		} catch (Exception e) {
			
		}
		return response;
	}

	
	private AccountSummary getAccountSummary(Long accoutNo) {
		AccountSummary summary=null;
		try {
			summary=accountSummaryRepository.findByAccountNo(accoutNo);
		} catch (Exception e) {
			
		}
		return summary;
	}
	
	@Override
	public List<TransactionDto> getRecentTransaction(Long accountNo) {
		 List<TransactionDto> response=new ArrayList<>();
		try {
			List<Transaction> list = transactionRepository.findByAccountNumberOrderByTransactionDateDesc(accountNo);
			if(!list.isEmpty()) {
				list.stream().forEach(transaction ->{
					TransactionDto dto=new TransactionDto();
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
}
