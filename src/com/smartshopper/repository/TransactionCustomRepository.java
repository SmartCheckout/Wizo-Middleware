package com.smartshopper.repository;


import java.util.List;

import com.smartshopper.models.dbo.TransactionDO;

public interface TransactionCustomRepository {

	//Contains custom methods for the transaction document
	public TransactionDO updateTransaction(TransactionDO transaction);
	
	public List<TransactionDO> getTransactionsForCustomer(String status, String customerId);
}
