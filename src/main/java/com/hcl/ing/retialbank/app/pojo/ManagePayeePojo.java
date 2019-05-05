package com.hcl.ing.retialbank.app.pojo;

public class ManagePayeePojo {
	private Long payeeAccountNo;

	private Long otp;
	
	private Long accountNo;
	

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Long getPayeeAccountNo() {
		return payeeAccountNo;
	}

	public void setPayeeAccountNo(Long payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}
	
}
