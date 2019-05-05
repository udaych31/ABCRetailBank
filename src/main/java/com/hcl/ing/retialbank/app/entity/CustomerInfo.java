package com.hcl.ing.retialbank.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="customer_info")
@NamedQuery(name="CustomerInfo.getUserInfo" ,query="select ci from CustomerInfo ci where ci.userName=:userName")
public class CustomerInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "CUSTOMER_TYPE")
	private String customerType;
	
	@Column(name = "CUSTOMER_ACCESS")
	private Character customerAccess;
	
	@Column(name="ACCNO")
	private Long accno;
	
	public Long getAccno() {
		return accno;
	}

	public void setAccno(Long accno) {
		this.accno = accno;
	}

	public CustomerInfo() {
		super();
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

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

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Character getCustomerAccess() {
		return customerAccess;
	}

	public void setCustomerAccess(Character customerAccess) {
		this.customerAccess = customerAccess;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerInfo [customerId=");
		builder.append(customerId);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", customerType=");
		builder.append(customerType);
		builder.append(", customerAccess=");
		builder.append(customerAccess);
		builder.append("]");
		return builder.toString();
	}
	
	

}
