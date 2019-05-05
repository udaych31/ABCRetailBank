package com.hcl.ing.retialbank.app.dto;

import java.io.Serializable;

public class AccountUpdateResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public AccountUpdateResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountUpdateResponse [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

	
}
