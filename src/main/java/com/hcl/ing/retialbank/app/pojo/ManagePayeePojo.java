package com.hcl.ing.retialbank.app.pojo;

public class ManagePayeePojo {
	private Long payeeAccountNo;

	private Long accountNo;
	
	public ManagePayeePojo() {
		super();
	}

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManagePayeePojo [payeeAccountNo=");
		builder.append(payeeAccountNo);
		builder.append(", accountNo=");
		builder.append(accountNo);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
