package com.smartshopper.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="smartshopper.product")
public class Product {

	@Id
	private String id;
	private String sku;
	private String title;
	private String category;
	private Double retailPrice;
	
	public Product(){
		super();
	}
	
	public Product(String id, String sku, String title, String category,
			Double retailPrice) {
		super();
		this.id = id;
		this.sku = sku;
		this.title = title;
		this.category = category;
		this.retailPrice = retailPrice;
	}
	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return title;
	}
	public void setProductName(String productName) {
		this.title = productName;
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
	
	@Override
	public String toString(){
		return String.format("Product\nid=%d]s\nName = %s\nCategory = %s\nPrice=%f]",this.id,this.title,this.category,this.retailPrice);
	}
	
}
