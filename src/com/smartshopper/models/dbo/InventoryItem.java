package com.smartshopper.models.dbo;

public class InventoryItem {

	private String sku;
	private double discount;
	private double retailPrice;
	private int stock;
	
	public InventoryItem() {
		super();
	}
	

	public InventoryItem(String sku, double discount, double sellingPrice,
			int stock) {
		super();
		this.sku = sku;
		this.discount = discount;
		this.retailPrice = sellingPrice;
		this.stock = stock;
	}



	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getSellingPrice() {
		return retailPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.retailPrice = sellingPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
