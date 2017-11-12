package com.smartshopper.repository;

import java.util.List;

import com.smartshopper.models.dbo.TransactionDO;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TransactionMongoRepository extends MongoRepository<TransactionDO, String>, TransactionCustomRepository {
	public TransactionDO findOneBytrnsId(String transactionId);
	public TransactionDO insert(TransactionDO transaction);
	@Override
	public <S extends TransactionDO> List<S> findAll(Example<S> example);
}
