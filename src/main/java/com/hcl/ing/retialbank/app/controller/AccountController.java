package com.hcl.ing.retialbank.app.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retialbank.app.dto.AccountResponse;
import com.hcl.ing.retialbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retialbank.app.dto.AccountUpdateRequest;
import com.hcl.ing.retialbank.app.dto.AccountUpdateResponse;
import com.hcl.ing.retialbank.app.dto.CustomerDTO;
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.dto.TransactionDto;
import com.hcl.ing.retialbank.app.dto.UserResponse;
import com.hcl.ing.retialbank.app.service.AccountServiceImpl;
import com.hcl.ing.retialbank.app.service.CustomerServiceImpl;
import com.hcl.ing.retialbank.app.service.ExcelGenerator;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@PostMapping("/searchbyaccnoaccname")
	public AccountSummaryResponse searchByAccountNoOrAccountName(@RequestBody SearchRequest request) {
		return accountServiceImpl.searchByAccountNoOrAccountName(request);
	}
	
	@PostMapping("/updateaccount")
	public AccountUpdateResponse updateAccountDetails(@RequestBody AccountUpdateRequest request) {
		return accountServiceImpl.updateAccountDetails(request);
	}
	
	@GetMapping("/getrecenttrans")
	public List<TransactionDto> getRecentTransaction(@RequestParam("accountNo") Long accountNo){
		return accountServiceImpl.getRecentTransaction(accountNo);
	}
	
	@GetMapping(value = "/download/transactions.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport(@RequestParam("accountNo") Long accountNo) throws IOException {
	        List<TransactionDto> customers = (List<TransactionDto>) accountServiceImpl.getRecentTransaction(accountNo);
	    
	    ByteArrayInputStream in = ExcelGenerator.customersToExcel(customers);
	    
	    HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
	     return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }
	
	@PostMapping("/accont/create")
	public UserResponse createAccout(@RequestBody CustomerDTO customerDto) {
		
		   UserResponse response=customerService.createAccount(customerDto);
		         
		
		return response;
			
	}
	
	@GetMapping("/accountdetails")
	public  AccountResponse accountDetails(@RequestParam String username) {
		AccountResponse response=customerService.accountDetails(username);	
		
		return response;
	}

}

	


