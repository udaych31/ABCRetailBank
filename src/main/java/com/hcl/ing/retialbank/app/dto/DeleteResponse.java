package com.hcl.ing.retialbank.app.dto;

import java.io.Serializable;

public class DeleteResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public DeleteResponse() {
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
		builder.append("DeleteResponse [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
	
	

}
