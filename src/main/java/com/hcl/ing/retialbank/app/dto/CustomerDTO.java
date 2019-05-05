package com.hcl.ing.retialbank.app.dto;

public class CustomerDTO {
	

		
		private String accountType;
		private String accountName;
		private String dob;
		private String address;
		private String branchName;
		private Double closingBalance;
		private String role;


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

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}


}
