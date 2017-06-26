package com.smartshopper.models.io;

import java.util.Date;
import java.util.List;

import com.smartshopper.models.User;
import com.smartshopper.models.dbo.TransactionDO;

public class Transaction {
	
	
	private String trnsId;
	private Date trnsDate;
	private Store store;
	private User customer;
	List<CartItem> cart;
	private Double grandTotal;
	
	public Transaction(String trnsId, Date trnsDate, Store store, User customer, List<CartItem> cart,
			Double grandTotal) {
		super();
		this.trnsId = trnsId;
		this.trnsDate = trnsDate;
		this.store = store;
		this.customer = customer;
		this.cart = cart;
		this.grandTotal = grandTotal;
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
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	

}
