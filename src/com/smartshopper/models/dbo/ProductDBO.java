package com.smartshopper.models.dbo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.smartshopper.models.io.Product;


@Document(collection="smartshopper.product")
public class ProductDBO{

	@Id
	private String uniqueId;
	private String barcode;
	private String title;
	private String description;
	private String category;
	private Double retailPrice;
	private Float discount;
	
	public ProductDBO(){
		super();
	}
	
	public ProductDBO(String uniqueId, String barcode, String title,
			String description, String category, Double retailPrice,Float discount) {
		super();
		this.uniqueId = uniqueId;
		this.barcode = barcode;
		this.title = title;
		this.description = description;
		this.category = category;
		this.retailPrice = retailPrice;
		this.discount = discount;
	}


	public Product toIO(){
		return new Product(uniqueId, barcode, title, description, category, retailPrice, discount);
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

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}


	public Double getRetailPrice() {
		return retailPrice;
	}


	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	
	
	
}
