package com.smartshopper.models.io;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.smartshopper.common.Mappable;
import com.smartshopper.models.Bill;
import com.smartshopper.models.Payment;
import com.smartshopper.models.dbo.CartItemDO;
import com.smartshopper.models.dbo.StoreDO;
import com.smartshopper.models.dbo.TransactionDO;
import com.smartshopper.repository.User;

public class Transaction implements Mappable {
	
	protected String trnsId;
	private Date trnsDate;
	private String status;
	private Date createTS;
	private Date updateTS;
	private Store store;
	private User customer;
	private List<CartItem> cart;
	private Bill bill;
	private List<Payment> payment;
	
	public Transaction(String trnsId, Date trnsDate, String status, Date createTS, Date updateTS, Store store, List<CartItem> cart, User customer, Bill bill,
			List<Payment> payment) {
		super();
		this.trnsId = trnsId;
		this.trnsDate = trnsDate;
		this.status = status;
		this.createTS = createTS;
		this.updateTS = updateTS;
		this.store = store;
		this.customer = customer;
		this.cart = cart;
		this.bill = bill;
		this.payment = payment;
		this.status = status;
	}

	public Transaction(){
		super();
	}
	public TransactionDO toDO(){
		StoreDO storeDO = store!=null ? store.toDBO() : null;
		List<CartItemDO> cartDO = null;
		if(cart!=null){
			 cartDO = new ArrayList<CartItemDO>();
			 for(CartItem item : cart){
				cartDO.add(item.toDBO());
			}
		}
		
		return new TransactionDO(trnsId, trnsDate, status, createTS, updateTS, storeDO, cartDO, customer, bill, payment);
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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public List<CartItem> getCart() {
		return cart;
	}

	public void setCart(List<CartItem> cart) {
		this.cart = cart;
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
