package com.hcl.ing.retialbank.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ing.retialbank.app.entity.ManagePayee;
import com.hcl.ing.retialbank.app.entity.Transaction;


public interface PayeeRepository extends JpaRepository<ManagePayee, Long>{

	public List<ManagePayee> findByPayeeId(Long accountNumber);
}
