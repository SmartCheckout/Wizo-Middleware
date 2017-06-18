package com.smartshopper.models.dbo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.smartshopper.models.User;

@Document(collection="smartshopper.transaction")
public class TransactionDO {
	@Id
	private String trnsId;
	private Date trnsDate;
	@DBRef
	private StoreDO store;
	@DBRef
	private User customer;
	List<CartItemDO> cart;
	private Double grandTotal;
	
	public TransactionDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TransactionDO(String trnsId, Date trnsDate, StoreDO store, User customer,
			List<CartItemDO> cart, Double grandTotal) {
		super();
		this.trnsId = trnsId;
		this.trnsDate = trnsDate;
		this.store = store;
		this.customer = customer;
		this.cart = cart;
		this.grandTotal = grandTotal;
	}
	public String getTrnsId(){
		return this.trnsId;
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
	public List<CartItemDO> getCart() {
		return cart;
	}
	public void setCart(List<CartItemDO> cart) {
		this.cart = cart;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
}
