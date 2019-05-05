package com.hcl.ing.retialbank.app.dto;

public class UserResponse {
	
	private String userName;
	private String password;
	
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
