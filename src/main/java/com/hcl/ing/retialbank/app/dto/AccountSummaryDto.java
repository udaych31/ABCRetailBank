package com.hcl.ing.retialbank.app.dto;

import java.io.Serializable;
import java.util.Date;

public class AccountSummaryDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long accountNo;
	
	private String accountType;
	
	private String accountName;
	
	private String dob;
	
	private String address;
	
	private String branchName;
	
	private Double closingBalance;
	
	private Date createDt;
	
	public AccountSummaryDto() {
		super();
	}

	
	public Long getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public Double getClosingBalance() {
		return closingBalance;
	}


	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}


	public Date getCreateDt() {
		return createDt;
	}


	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountSummaryDto [accountNo=");
		builder.append(accountNo);
		builder.append(", accountType=");
		builder.append(accountType);
		builder.append(", accountName=");
		builder.append(accountName);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", address=");
		builder.append(address);
		builder.append(", branchName=");
		builder.append(branchName);
		builder.append(", closingBalance=");
		builder.append(closingBalance);
		builder.append(", createDt=");
		builder.append(createDt);
		builder.append("]");
		return builder.toString();
	}
	
	

}
