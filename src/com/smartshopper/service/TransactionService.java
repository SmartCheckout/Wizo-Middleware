package com.smartshopper.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
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
	
	public Page<Transaction> searchTransactions(String status, String userId,Pageable pageable ){
		Page<TransactionDO> fetchedDOList = trnsRepo.getTransactionsForCustomer(status, userId,pageable);
				
		List<Transaction> fetchedList = new ArrayList<Transaction>();
		for(TransactionDO transDo:fetchedDOList)
		{
			fetchedList.add(transDo.toIO());
		}
		
		Page<Transaction> fetchedIOList =  PageableExecutionUtils.getPage(
				fetchedList, 
                pageable, 
                () -> fetchedDOList.getTotalElements());
		return fetchedIOList;
	}
}
