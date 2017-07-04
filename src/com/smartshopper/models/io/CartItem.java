package com.smartshopper.models.io;

import com.smartshopper.models.dbo.CartItemDO;
import com.smartshopper.models.dbo.ProductDO;

public class CartItem {

	private Product product;
	private Integer quantity;
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartItemDO toDBO(){
		ProductDO productDO = product == null ? null : product.toDBO();
		return new CartItemDO(productDO, quantity);
	}

	public CartItem(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
