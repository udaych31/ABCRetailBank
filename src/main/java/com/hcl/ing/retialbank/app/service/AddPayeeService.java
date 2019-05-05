package com.hcl.ing.retialbank.app.service;

import com.hcl.ing.retialbank.app.dto.AddPayeeReference;
import com.hcl.ing.retialbank.app.dto.ConfirmPayeeRequest;
import com.hcl.ing.retialbank.app.dto.ManagePayeeDto;

public interface AddPayeeService {
	
	
	public AddPayeeReference addPayee(ManagePayeeDto payee);
	
	public String confirmPayee(ConfirmPayeeRequest request);

}
