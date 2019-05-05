package com.hcl.ing.retialbank.app.dto;

import java.io.Serializable;
import java.util.List;

public class AccountSummaryResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<AccountSummaryDto> summaryList;
	
	public AccountSummaryResponse() {
		super();
	}

	public List<AccountSummaryDto> getSummaryList() {
		return summaryList;
	}

	public void setSummaryList(List<AccountSummaryDto> summaryList) {
		this.summaryList = summaryList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountSummaryResponse [summaryList=");
		builder.append(summaryList);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
