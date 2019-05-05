package com.hcl.ing.retialbank.app.service;

import com.hcl.ing.retialbank.app.dto.AddPayeeReference;
import com.hcl.ing.retialbank.app.dto.ConfirmPayeeRequest;
import com.hcl.ing.retialbank.app.dto.ManagePayeeDTO;

public interface AddPayeeService {
	
	
	public AddPayeeReference addPayee(ManagePayeeDTO payee);
	
	public String confirmPayee(ConfirmPayeeRequest request);

}
