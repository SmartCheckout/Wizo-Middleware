package com.smartshopper.models.dbo;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class CartItemDO {

	@DBRef
	private ProductDO product;
	private Integer quantity;
	private Double costPrice;
	private Float discount;
	private Double sellingPrice;
	
	public CartItemDO(ProductDO product, Integer quantity, Double costPrice,
			Float discount, Double sellingPrice) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.costPrice = costPrice;
		this.discount = discount;
		this.sellingPrice = sellingPrice;
	}
	public CartItemDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDO getProduct() {
		return product;
	}
	public void setProduct(ProductDO product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	
	
	
}
