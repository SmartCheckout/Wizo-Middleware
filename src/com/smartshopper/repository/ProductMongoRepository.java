package com.smartshopper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartshopper.models.dbo.ProductDO;

public interface ProductMongoRepository extends MongoRepository<ProductDO, String> {
	public ProductDO findOneByuniqueId(String id);
	public ProductDO findOneBybarcode(String sku);
	public ProductDO insert(ProductDO product);

}
