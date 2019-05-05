package com.hcl.ing.retialbank.app.service;

import java.util.List;

import com.hcl.ing.retialbank.app.dto.ManagePayeeDto;

public interface PayeeService {
	public List<ManagePayeeDto> getPayeesList(Long accountNo);
}
