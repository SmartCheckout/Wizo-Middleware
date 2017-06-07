package com.smartshopper.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartshopper.models.Product;

public interface ProductMongoRepository extends MongoRepository<Product, String>{
	
	public Product findBysku(String sku);
	public List<Product> findByCategory(String category);

}
