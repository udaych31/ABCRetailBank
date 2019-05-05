package com.hcl.ing.retialbank.app.dto;

import java.io.Serializable;

public class ConfirmPayeeRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long accountNo;
	
	private Long referenceNo;
	
	private Long otp;
	
	public ConfirmPayeeRequest() {
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Long getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(Long referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}
	
	

}
