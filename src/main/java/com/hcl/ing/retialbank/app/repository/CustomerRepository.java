package com.hcl.ing.retialbank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retialbank.app.entity.CustomerInfo;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerInfo, Long> {
	
	@Query
	public CustomerInfo getUserInfo(String userName);

	public CustomerInfo  findByUserName(String userName);

}
