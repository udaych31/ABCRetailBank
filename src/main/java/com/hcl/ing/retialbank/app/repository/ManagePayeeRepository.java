package com.hcl.ing.retialbank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retialbank.app.entity.ManagePayee;



@Repository
public interface ManagePayeeRepository extends JpaRepository<ManagePayee, Long>{

	
    ManagePayee findByPayeeAccountNo(Long payeeAccountNo);

	public ManagePayee findByAccountNo(Long accno);
	
	public boolean deleteByPayeeId(Long payeeId);

}
