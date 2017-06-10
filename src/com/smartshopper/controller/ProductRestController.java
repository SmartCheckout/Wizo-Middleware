package com.smartshopper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopper.models.io.Product;
import com.smartshopper.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET,path="/product")
	public Product getProductDetails(@RequestParam(value="id",required=false) String productId,
										@RequestParam(value="sku",required=false) String sku){
		Product result = null;
		if(productId!=null){
			//validate if product id is empty
			if(!productId.trim().isEmpty()){
				result = productService.getProductDetailsById(productId);
			}else{
				//Valdation Error response
			}
		}else if(sku!=null){
			if(!sku.trim().isEmpty()){
				result = productService.getProductDetailsBySKU(sku);
			}else{
				//Validation Error Response
			}
		}
		return result;
	}
	
	@RequestMapping(path="/product/add", method = RequestMethod.POST)
	public String addProduct(@RequestBody Product product){
		return productService.addProduct(product);
	}
}
