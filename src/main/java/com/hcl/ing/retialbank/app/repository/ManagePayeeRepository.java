package com.hcl.ing.retialbank.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retialbank.app.entity.ManagePayee;



@Repository
@Transactional
public interface ManagePayeeRepository extends JpaRepository<ManagePayee, Long>{

	
    ManagePayee findByPayeeAccountNo(Long payeeAccountNo);

	public ManagePayee findByAccountNo(Long accno);
	
	public Integer deleteByPayeeId(Long payeeId);

}
