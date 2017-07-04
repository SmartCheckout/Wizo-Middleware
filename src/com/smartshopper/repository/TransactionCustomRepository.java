package com.smartshopper.repository;

import com.smartshopper.models.dbo.TransactionDO;

public interface TransactionCustomRepository {

	//Contains custom methods for the transaction document
	public TransactionDO updateTransaction(TransactionDO transaction);
}
