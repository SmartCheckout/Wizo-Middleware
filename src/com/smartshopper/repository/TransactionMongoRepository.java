package com.smartshopper.repository;

import com.smartshopper.models.dbo.TransactionDO;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TransactionMongoRepository extends MongoRepository<TransactionDO, String>, TransactionCustomRepository {
	public TransactionDO findOneBytrnsId(String transactionId);
	public TransactionDO insert(TransactionDO transaction);

}
