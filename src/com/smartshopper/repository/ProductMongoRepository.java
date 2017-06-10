package com.smartshopper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartshopper.models.dbo.ProductDBO;

public interface ProductMongoRepository extends MongoRepository<ProductDBO, String> {
	public ProductDBO findOneByuniqueId(String id);
	public ProductDBO findOneBybarcode(String sku);
	public ProductDBO insert(ProductDBO product);

}
