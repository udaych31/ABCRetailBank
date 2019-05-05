package com.hcl.ing.retialbank.app.dto;

public class UserResponse {
	
	private String userName;
	private String password;
	private String message;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

		builder.append("userName=");
		builder.append(userName);
		builder.append(",password=");
		builder.append(password);
		
		return builder.toString();
	}
	
	
	
	
	
	
	
	

}
