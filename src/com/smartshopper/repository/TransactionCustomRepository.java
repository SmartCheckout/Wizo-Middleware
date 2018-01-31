package com.smartshopper.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smartshopper.models.dbo.TransactionDO;

public interface TransactionCustomRepository {

	//Contains custom methods for the transaction document
	public TransactionDO updateTransaction(TransactionDO transaction);
	
	public Page<TransactionDO> getTransactionsForCustomer(String status, String customerId,Pageable pageable);
}
