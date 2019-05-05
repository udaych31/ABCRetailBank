package com.hcl.ing.retialbank.app.dto;

import java.io.Serializable;
import java.util.Date;

public class TransactionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	Long transactionId;
	String transactionType;
	Date transactionDate;
	Long fromAccountNumber;
	Long accountNumber;
	Double transactionAmount;
	String transactionRemarks;
	Double closingBalance;
	
	public TransactionDto() {
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(Long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionRemarks() {
		return transactionRemarks;
	}

	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}

	public Double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionDto [transactionId=");
		builder.append(transactionId);
		builder.append(", transactionType=");
		builder.append(transactionType);
		builder.append(", transactionDate=");
		builder.append(transactionDate);
		builder.append(", fromAccountNumber=");
		builder.append(fromAccountNumber);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append(", transactionAmount=");
		builder.append(transactionAmount);
		builder.append(", transactionRemarks=");
		builder.append(transactionRemarks);
		builder.append(", closingBalance=");
		builder.append(closingBalance);
		builder.append("]");
		return builder.toString();
	}
	
	
}
