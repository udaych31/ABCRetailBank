package com.hcl.ing.retialbank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retialbank.app.entity.OtpDetails;

@Repository
public interface OtpRepository extends JpaRepository<OtpDetails, Long> {

	public OtpDetails findByAccountNo(Long accountNo);
	
}
