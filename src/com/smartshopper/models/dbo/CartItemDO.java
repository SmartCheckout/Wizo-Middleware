package com.smartshopper.models.dbo;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.smartshopper.models.io.CartItem;
import com.smartshopper.models.io.Product;

public class CartItemDO {

	@DBRef
	private ProductDO product;
	private Integer quantity;
	
	public CartItemDO(ProductDO product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public CartItem toIO(){
		Product productIO = product == null ? null : product.toIO();
		return new CartItem(productIO, quantity);
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
	
}
