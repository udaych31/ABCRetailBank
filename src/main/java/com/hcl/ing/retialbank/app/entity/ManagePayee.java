package com.hcl.ing.retialbank.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class ManagePayee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long payeeId;
	
	private Long accountNo;
	
	private String payeeName;
	
	private String payeeAccountNo;
	
	private String nickName;
	
	public ManagePayee() {
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

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeAccountNo() {
		return payeeAccountNo;
	}

	public void setPayeeAccountNo(String payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManagePayee [payeeId=");
		builder.append(payeeId);
		builder.append(", accountNo=");
		builder.append(accountNo);
		builder.append(", payeeName=");
		builder.append(payeeName);
		builder.append(", payeeAccountNo=");
		builder.append(payeeAccountNo);
		builder.append(", nickName=");
		builder.append(nickName);
		builder.append("]");
		return builder.toString();
	}
	
	

}
