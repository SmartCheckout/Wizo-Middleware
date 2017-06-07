package com.smartshopper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopper.exceptions.UserNotFoundException;
import com.smartshopper.models.Product;
import com.smartshopper.repository.ProductMongoRepository;

@RestController
public class ProductRestController {

	@Autowired
	private ProductMongoRepository productRepo; 
	@RequestMapping(path="products")
	public List<Product> getAllProducts(){
		return	productRepo.findAll();
	}
	
	@RequestMapping(path="products/{id}")
	public Product getByProductId(@PathVariable(name="id") String productId)throws UserNotFoundException{
		if(productId.equalsIgnoreCase("error")){
			throw new UserNotFoundException();
		}
		return productRepo.findOne(productId);
	}
	
	@RequestMapping(path="products/add", method = RequestMethod.POST)
	public String addProduct(@RequestBody Product productInfo){
		productRepo.insert(productInfo);
		return "Completed";
	}
	

	@RequestMapping(path="products/sku/{sku}")
	public Product addProduct(@PathVariable String sku){
		return productRepo.findBysku(sku);
	}
	
	@RequestMapping(path="products/category/{category}")
	public List<Product> getByProductCategory(@PathVariable  String category){
		return productRepo.findByCategory(category);
	}
	
}
