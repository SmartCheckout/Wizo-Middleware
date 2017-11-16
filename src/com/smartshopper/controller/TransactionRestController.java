package com.smartshopper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopper.models.io.Transaction;
import com.smartshopper.service.TransactionService;;

@RestController
public class TransactionRestController {
	@Autowired
	private TransactionService trnsService;
	

	@RequestMapping(path="/transaction", method = RequestMethod.GET)
	public Transaction getTransaction(@RequestParam(value="trnsId",required=true) String trnsId){
		return trnsService.getTransaction(trnsId);
		
	}
	
	@RequestMapping(path="/transaction/search", method = RequestMethod.GET)
	public List<Transaction> getTransactionsForCustomer(@RequestParam(value="userId",required=true) String userId,@RequestParam(value="status",required=true) String status){
		return trnsService.searchTransactions(status, userId);
		
	}
	
	@RequestMapping(path="/transaction/create", method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody Transaction trns){
		return trnsService.crerateTransaction(trns);
	}
	
	@RequestMapping(path="/transaction/update", method = RequestMethod.POST)
	public Transaction updateTransaction(@RequestBody Transaction trns){
		return trnsService.updateTransStatus(trns);
	}
	
}
