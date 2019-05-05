package com.hcl.ing.retialbank.app.dto;

import java.io.Serializable;

public class AddPayeeReference implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long referenceNo;
	
	private String message;
	
	public AddPayeeReference() {
	}

	public Long getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(Long referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AddPayeeReference [referenceNo=" + referenceNo + ", message=" + message + "]";
	}
	
	
	
	
}
