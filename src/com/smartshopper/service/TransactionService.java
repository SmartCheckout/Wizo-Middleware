package com.smartshopper.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshopper.models.dbo.TransactionDO;
import com.smartshopper.models.io.Transaction;
import com.smartshopper.repository.TransactionMongoRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionMongoRepository trnsRepo;
	
	public Transaction crerateTransaction(Transaction transaction){
		Transaction inserted = null;
		if(transaction!=null){
			TransactionDO transDO = transaction.toDO();
			transDO.setTrnsId(new ObjectId().toHexString());
			inserted = trnsRepo.insert(transDO).toIO();
		}
		
		return inserted;
	}
	
	public Transaction updateTransStatus(Transaction transaction){
		Transaction updated = null;
		if(transaction!=null){
			TransactionDO updatedDO = trnsRepo.updateTransaction(transaction.toDO());
			if(updatedDO!=null){
				updated = updatedDO.toIO(); 
			}
		}
		return updated;
	}
	
	public Transaction getTransaction(String trnsId){
		Transaction fetched = null;
		TransactionDO fetchedDO = trnsRepo.findOne(trnsId);
		if(fetchedDO!=null){
			fetched = fetchedDO.toIO();
		}
		return fetched;
	}
}
