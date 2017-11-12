package com.smartshopper.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.smartshopper.models.dbo.StoreDO;
import com.smartshopper.models.dbo.TransactionDO;
import com.smartshopper.models.io.Transaction;
import com.smartshopper.models.io.User;
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
	
	public List<Transaction> searchTransactions(String status, User customer, Date trnsDate, String storeId ){
		List<Transaction> result = new ArrayList<Transaction>();
		StoreDO store = storeId!=null ?new StoreDO(storeId) : null;
		Example<TransactionDO> tExample = Example.of(new TransactionDO(null, trnsDate, status, null, null, store, null, null, null,null));
		for(TransactionDO tDO : trnsRepo.findAll(tExample)){
			result.add(tDO.toIO());
		}
		
		return result;
	}
}
