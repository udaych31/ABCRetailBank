package com.hcl.ing.retialbank.app.dto;

import java.io.Serializable;

public class SearchRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long accountNo;
	
	private String accountName;
	
	public SearchRequest() {
		super();
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchRequest [accountNo=");
		builder.append(accountNo);
		builder.append(", accountName=");
		builder.append(accountName);
		builder.append("]");
		return builder.toString();
	}

	
}
