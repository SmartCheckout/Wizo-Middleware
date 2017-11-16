package com.smartshopper.models.dbo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.smartshopper.common.Mappable;
import com.smartshopper.models.Bill;
import com.smartshopper.models.Payment;
import com.smartshopper.models.io.CartItem;
import com.smartshopper.models.io.Store;
import com.smartshopper.models.io.Transaction;
import com.smartshopper.models.io.User;

@Document(collection="smartshopper.transaction")
public class TransactionDO implements Mappable {
	@Id
	private String trnsId;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date trnsDate;
	private String status;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createTS;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updateTS;
	
	@DBRef
	private StoreDO store;
	//@DBRef
	private User customer;
	List<CartItemDO> cart;
	private Bill bill;
	private List<Payment> payment;
	
	public TransactionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public TransactionDO(String trnsId, Date trnsDate, String status, Date createTS, Date updateTS, StoreDO store, List<CartItemDO> cart,
			User customer, Bill bill, List<Payment> payment) {
		super();
		this.trnsId = trnsId;
		this.trnsDate = trnsDate;
		this.status = status;
		this.updateTS = updateTS;
		this.store = store;
		this.customer = customer;
		this.cart = cart;
		this.bill = bill;
		this.payment = payment;
	}

	public Transaction toIO(){
		Store storeIO = store ==null ? null : store.toIO();
		List<CartItem> cartIO = null;
		
		if(cart!=null){
			cartIO = new ArrayList<CartItem>();
			for(CartItemDO item : cart){
				cartIO.add(item.toIO());
			}
		}
		
		return new Transaction(trnsId, trnsDate, status, createTS, updateTS, storeIO, cartIO, customer, bill, payment);
	}

	public String getTrnsId() {
		return trnsId;
	}

	public void setTrnsId(String trnsId) {
		this.trnsId = trnsId;
	}

	public Date getTrnsDate() {
		return trnsDate;
	}

	public void setTrnsDate(Date trnsDate) {
		this.trnsDate = trnsDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTS() {
		return createTS;
	}

	public void setCreateTS(Date createTS) {
		this.createTS = createTS;
	}

	public Date getUpdateTS() {
		return updateTS;
	}

	public void setUpdateTS(Date updateTS) {
		this.updateTS = updateTS;
	}

	public StoreDO getStore() {
		return store;
	}

	public void setStore(StoreDO store) {
		this.store = store;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	
	public List<CartItemDO> getCart() {
		return cart;
	}


	public void setCart(List<CartItemDO> cart) {
		this.cart = cart;
	}
	
	@Override
	public HashMap<String, Object> toMap(){
		HashMap<String, Object> result = new HashMap<String, Object>();
		Field fields[] = this.getClass().getDeclaredFields();
		for(int index =0; index< fields.length; index++){
			try{
				Object value = fields[index].get(this);
				if(value != null){
					result.put(fields[index].getName(), value);
				}
			}catch(IllegalAccessException ia){
				System.err.println(fields[index].getName() + " inaccesible");
			}
		}
		return result;
	}
}
