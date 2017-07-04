package com.smartshopper.repository;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
				update.set(key, objectMap.get(key));
			}
			
			mongoTemplate.updateFirst(query, update, TransactionDO.class);
			updated = mongoTemplate.findOne(query, TransactionDO.class);
		}
		return updated;
	}

}
