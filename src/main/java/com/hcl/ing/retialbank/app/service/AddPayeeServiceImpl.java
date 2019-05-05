package com.hcl.ing.retialbank.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.retialbank.app.dto.AddPayeeReference;
import com.hcl.ing.retialbank.app.dto.ConfirmPayeeRequest;
import com.hcl.ing.retialbank.app.dto.ManagePayeeDTO;
import com.hcl.ing.retialbank.app.dto.OtpRequest;
import com.hcl.ing.retialbank.app.dto.ValidateOtpRequest;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.entity.ManagePayee;
import com.hcl.ing.retialbank.app.entity.OtpDetails;
import com.hcl.ing.retialbank.app.entity.TempPayee;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.ManagePayeeRepository;
import com.hcl.ing.retialbank.app.repository.OtpRepository;
import com.hcl.ing.retialbank.app.repository.TempPayeeRepository;

@Service
public class AddPayeeServiceImpl implements AddPayeeService {

	@Autowired
	ManagePayeeRepository repository;
	
	@Autowired
	TempPayeeRepository tempPayeeRepository;


	@Autowired
	AccountSummaryRepository accountRepository;
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@Autowired
	private OtpRepository otpRepository;

	@Override
	public AddPayeeReference addPayee(ManagePayeeDTO payee) {
		AddPayeeReference reference=new  AddPayeeReference();
		TempPayee managePayee = new TempPayee();
		AccountSummary account = accountRepository.findByAccountNo(payee.getAccountNo());
		if(account!=null) {
			OtpRequest request=new OtpRequest();
			request.setAccountNo(payee.getAccountNo());
			request.setEmail(account.getEmail());
			boolean sendOtp = accountServiceImpl.sendOtp(request);
			if(sendOtp) {
				managePayee.setAccountNo(payee.getAccountNo());
				managePayee.setNickName(payee.getNickName());
				managePayee.setPayeeAccountNo(payee.getPayeeAccountNo());
				managePayee.setPayeeName(payee.getPayeeName());
				TempPayee save = tempPayeeRepository.save(managePayee);
				reference.setReferenceNo(save.getAccountNo());
				reference.setMessage("OTP send successfully .. ! Use this reference no for adding payee..!");
			}
		}
		return reference;

	}
	
	@Override
	public String confirmPayee(ConfirmPayeeRequest request) {
		try {
			ValidateOtpRequest otpReq=new ValidateOtpRequest();
			otpReq.setAccountNo(request.getAccountNo());
			otpReq.setOtp(request.getOtp());
			OtpDetails otp = accountServiceImpl.validateOtp(otpReq);
			if(otp!=null) {
				otp.setOtpUsed('T');
				otpRepository.save(otp);
				TempPayee findByPayeeId = tempPayeeRepository.findByPayeeId(request.getReferenceNo());
				if(findByPayeeId!=null) {
					ManagePayee payee=new ManagePayee();
					payee.setAccountNo(request.getAccountNo());
					payee.setNickName(findByPayeeId.getNickName());
					payee.setPayeeAccountNo(findByPayeeId.getPayeeAccountNo());
					payee.setPayeeName(findByPayeeId.getPayeeName());
					repository.save(payee);
					return "Payee added successfully..!";
				}else {
					return "some thing wrong..!";
				}
				
				
			}else {
				return "OTP invalid..!";
			}
			
			
			
		} catch (Exception e) {
		}
		
		return null;
	}

}
