package com.smartshopper.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.smartshopper.models.dbo.TransactionDO;

public class TransactionMongoRepositoryImpl implements TransactionCustomRepository {
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	@Override
	public TransactionDO updateTransaction(TransactionDO transaction){
		TransactionDO updated = null;
		if(transaction!=null && !StringUtils.isEmpty(transaction.getTrnsId())){
			Query query = new Query();
			query.addCriteria(Criteria.where("trnsId").is(transaction.getTrnsId()));
			
			HashMap<String, Object> objectMap = transaction.toMap();
			Update update = new Update();
			for(String key : objectMap.keySet()){
				// updating other attributes
				Object value = objectMap.get(key);
				// Supporting payment entries to be added to the list instead of replacing the entire list
				if("PAYMENT".equals(key.toUpperCase())){
					update.addToSet(key).each(value);
				}else{
					update.set(key, objectMap.get(key));
				}
			}
			
			mongoTemplate.updateFirst(query, update, TransactionDO.class);
			updated = mongoTemplate.findOne(query, TransactionDO.class);
		}
		return updated;
	}

	@Override
	public List<TransactionDO> getTransactionsForCustomer(String status, String customerId) {
		
		Query query = new Query();
		Pageable pageable = new PageRequest(0,5);
		query.with(pageable);
		query.addCriteria(Criteria.where("status").is(status));
		query.addCriteria(Criteria.where("customer.userId").is(customerId));
		
		List<TransactionDO> transactionList = mongoTemplate.find(query, TransactionDO.class);
		
		return transactionList;
	}
	
	

}
