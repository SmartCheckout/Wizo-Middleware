package com.smartshopper.models;

public class Bill {
	private Double subTotal;
	private Double tax;
	private Double total;
	private Double savings;
	
	public Bill(){
		super();
	}
	
	public Bill(Double subTotal, Double tax, Double total) {
		super();
		this.subTotal = subTotal;
		this.tax = tax;
		this.total = total;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	

}
