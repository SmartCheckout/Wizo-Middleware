package com.smartshopper.models.io;

import com.smartshopper.models.dbo.ProductDBO;

public class Product{

	private String uniqueId;
	private String barcode;
	private String title;
	private String description;
	private String category;
	private Double retailPrice;
	private Float discount;

	public Product(){
		super();
	}
	public Product(String uniqueId, String barcode, String title, String description, String category, Double retailPrice, Float discount) {
		this.uniqueId = uniqueId;
		this.barcode = barcode;
		this.title = title;
		this.description = description;
		this.category = category;
		this.retailPrice = retailPrice;
		this.discount = discount;
	}
	
	public ProductDBO toDBO(){
		return new ProductDBO(uniqueId, barcode, title, description, category, retailPrice, discount);
	}
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}
