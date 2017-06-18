package com.smartshopper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

import com.smartshopper.exceptions.Exceptions.*;
import com.smartshopper.models.io.Product;
import com.smartshopper.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET,path="/product")
	public Product getProductDetails(@RequestParam(value="id",required=false) String productId,
										@RequestParam(value="sku",required=false) String sku) 
										throws DataValidationException, ProductNotFoundException{
		Product result = null;
		if(StringUtils.isEmpty(productId) && StringUtils.isEmpty(sku)){
			throw new DataValidationException("Product id or SKU is required");
		}
		
		try{
			if(!StringUtils.isEmpty(productId)){
				result = productService.getProductDetailsById(productId);
			}else if(!StringUtils.isEmpty(sku)){
				result = productService.getProductDetailsBySKU(sku);
			}
		
			if(result == null) throw new ProductNotFoundException("Product details unavailable");
		}catch(ProductNotFoundException pex){
			
			//Log controller Error
			System.out.println(pex.getClass() + " exception caught and rethrown");
			throw pex;
		}
		
		return result;
	}
	
	@RequestMapping(path="/product/add", method = RequestMethod.POST)
	public String addProduct(@RequestBody Product product){
		return productService.addProduct(product);
	}
}
