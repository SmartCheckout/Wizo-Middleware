package com.smartshopper.models.dbo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="smartshopper.order")
public class Order {
	@Id
	private String orderId;
	private Date orderDate;
	@DBRef
	private StoreDBO store;
	@DBRef
	private User customer;
	List<CartItem> cart;
	private Double grandTotal;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(String orderId, Date orderDate, StoreDBO store, User customer,
			List<CartItem> cart, Double grandTotal) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.store = store;
		this.customer = customer;
		this.cart = cart;
		this.grandTotal = grandTotal;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public StoreDBO getStore() {
		return store;
	}
	public void setStore(StoreDBO store) {
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
