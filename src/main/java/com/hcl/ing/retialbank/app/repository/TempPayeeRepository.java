package com.hcl.ing.retialbank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retialbank.app.entity.TempPayee;

@Repository
public interface TempPayeeRepository extends JpaRepository<TempPayee, Long> {
	public TempPayee findByPayeeId(Long payeeId);
}
