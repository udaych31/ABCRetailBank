package com.hcl.ing.retialbank.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retialbank.app.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{	
	
	public List<Transaction> findByAccountNumberOrderByTransactionDateDesc(Long fromAccountNumber);

}
