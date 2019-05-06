package com.hcl.ing.retialbank.app.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.hcl.ing.retialbank.app.dto.AddPayeeReference;
import com.hcl.ing.retialbank.app.dto.ConfirmPayeeRequest;
import com.hcl.ing.retialbank.app.dto.CustomerDTO;
import com.hcl.ing.retialbank.app.dto.DeletePayeeConfirm;
import com.hcl.ing.retialbank.app.dto.DeleteResponse;

import com.hcl.ing.retialbank.app.dto.ManagePayeeDto;

import com.hcl.ing.retialbank.app.dto.OtpRequest;
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.dto.TransactionDto;
import com.hcl.ing.retialbank.app.dto.UserResponse;
import com.hcl.ing.retialbank.app.pojo.ManagePayeePojo;
import com.hcl.ing.retialbank.app.service.AccountServiceImpl;
import com.hcl.ing.retialbank.app.service.AddPayeeServiceImpl;
import com.hcl.ing.retialbank.app.service.CustomerServiceImpl;
import com.hcl.ing.retialbank.app.service.ExcelGenerator;
import com.hcl.ing.retialbank.app.service.PayeeServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@Autowired
	private AddPayeeServiceImpl addPayeeService;
	
	@Autowired
	private PayeeServiceImpl payeeServiceImpl;
	
	@PostMapping("/searchbyaccnoaccname")
	@ApiOperation(
			value = "Search by account number or name",
		    notes = "If it is success it returns a list of customers information or else it gives empty ")	
	public AccountSummaryResponse searchByAccountNoOrAccountName(@RequestBody SearchRequest request) {
		return accountServiceImpl.searchByAccountNoOrAccountName(request);
	}
	
	@PostMapping("/updateaccount")
	@ApiOperation(
			value = "Update the customer account",
		    notes = "If it is success it returns updated successfull message")	
	public AccountUpdateResponse updateAccountDetails(@RequestBody AccountUpdateRequest request) {
		return accountServiceImpl.updateAccountDetails(request);
	}
	
	@GetMapping("/getrecenttrans")
	@ApiOperation(
			value = "Get the recent transactions lists what ever the customer made",
		    notes = "If it is success it returns a list of transaction information or else it gives empty ")	
	public List<TransactionDto> getRecentTransaction(@RequestParam("accountNo") Long accountNo){
		return accountServiceImpl.getRecentTransaction(accountNo);
	}
	
	@GetMapping(value = "/download/transactions.xlsx")
	@ApiOperation(
			value = "Download the transaction list with excel sheet format",
		    notes = "If it is success it download the excel")	
    public ResponseEntity<InputStreamResource> excelCustomersReport(@RequestParam("accountNo") Long accountNo) throws IOException {
	        List<TransactionDto> customers = (List<TransactionDto>) accountServiceImpl.getRecentTransaction(accountNo);
	    
	    ByteArrayInputStream in = ExcelGenerator.customersToExcel(customers);
	    
	    HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
	     return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }
	
	@PostMapping("/accont/create")
	@ApiOperation(
			value = "Create the Account for customer",
		    notes = "If it is success it returns customer added successfull message ")	
	public UserResponse createAccout(@RequestBody CustomerDTO customerDto) {
		
		   UserResponse response=customerService.createAccount(customerDto);
		         
		
		return response;
			
	}
	
	@GetMapping("/accountdetails")
	@ApiOperation(
			value = "Display the account details by username",
		    notes = "It returns a list of account by username")	
	public  AccountResponse accountDetails(@RequestParam String username) {
		AccountResponse response=customerService.accountDetails(username);	
		
		return response;
	}
	
	
	@GetMapping("/getPayeesList")
	@ApiOperation(
			value = "Get the payees information what ever added the customer by account number",
		    notes = "It returns a list of payees information or else it gives empty ")	
	public List<ManagePayeeDto> getPayeesList(@RequestParam("accountNo") Long accountNo){
		return payeeServiceImpl.getPayeesList(accountNo);
	}
	@GetMapping("/sendotp")
	@ApiOperation(
			value = "Generate OTP",
		    notes = "If it is success it returns a 4 digit otp")	
	public  String accountDetails(@RequestBody OtpRequest request) {
		accountServiceImpl.sendOtp(request);
		return "otp generated successfully";
	}

	@DeleteMapping("/payee/deletepayee")
	public  DeleteResponse deletepayee(@RequestBody ManagePayeePojo managePayeePojo) {
		DeleteResponse response=accountServiceImpl.deletepayee(managePayeePojo);
		
		return response;
	}
	
	@DeleteMapping("/payee/deletepayeeconfirmation")
	public  DeleteResponse deletepayeeConfirmation(@RequestBody DeletePayeeConfirm deletePayeeConfirm) {
		DeleteResponse response=accountServiceImpl.deletePayeeConfirm(deletePayeeConfirm);
		
		return response;
	}
	
	@PostMapping("/addpayee")
	public  AddPayeeReference addPayee(@RequestBody ManagePayeeDto managePayeeDTO) {
		AddPayeeReference response=addPayeeService.addPayee(managePayeeDTO);	
		return response;
	}
	
	@PostMapping("/confirmpayee")
	public  String confirmPayee(@RequestBody ConfirmPayeeRequest request) {
		String response=addPayeeService.confirmPayee(request);	
		return response;
	}



}

	


