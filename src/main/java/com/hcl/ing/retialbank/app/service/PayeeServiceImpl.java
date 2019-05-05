package com.hcl.ing.retialbank.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.retialbank.app.dto.ManagePayeeDto;
import com.hcl.ing.retialbank.app.entity.ManagePayee;
import com.hcl.ing.retialbank.app.repository.PayeeRepository;

@Service
public class PayeeServiceImpl implements PayeeService{

	@Autowired
	PayeeRepository payeeRepository;
	
	
	@Override
	public List<ManagePayeeDto> getPayeesList(Long accountNo) {
		 List<ManagePayeeDto> response=new ArrayList<ManagePayeeDto>();
		try {
			List<ManagePayee> list = payeeRepository.findByPayeeId(accountNo);
			if(!list.isEmpty()) {
				list.stream().forEach(payee ->{
					ManagePayeeDto dto=new ManagePayeeDto();
					dto.setAccountNo(payee.getAccountNo());					
					dto.setPayeeAccountNo(payee.getPayeeAccountNo());
					dto.setPayeeName(payee.getPayeeName());
					dto.setNickName(payee.getNickName());
					response.add(dto);
				});
			}
			
		} catch (Exception e) {
			
		}
		return response;
	}
	
	
}
