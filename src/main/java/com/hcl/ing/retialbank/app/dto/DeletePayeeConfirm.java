package com.hcl.ing.retialbank.app.dto;

import java.io.Serializable;

public class DeletePayeeConfirm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long payeeId;

	private Long accountNo;
	
	private Long otp;
	
	public DeletePayeeConfirm() {
		super();
	}

	public Long getPayeeId() {
		return payeeId;
	}


	public void setPayeeId(Long payeeId) {
		this.payeeId = payeeId;
	}


	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeletePayeeConfirm [payeeId=");
		builder.append(payeeId);
		builder.append(", accountNo=");
		builder.append(accountNo);
		builder.append(", otp=");
		builder.append(otp);
		builder.append("]");
		return builder.toString();
	}
	

}
