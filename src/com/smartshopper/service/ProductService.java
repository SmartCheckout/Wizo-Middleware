package com.smartshopper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshopper.models.dbo.ProductDO;
import com.smartshopper.models.io.Product;
import com.smartshopper.repository.ProductMongoRepository;

@Service
public class ProductService {

	@Autowired
	private ProductMongoRepository productRepo;

	public Product getProductDetailsBySKU(String sku){
		ProductDO productDBO =  productRepo.findOneBybarcode(sku); 
		return productDBO.toIO();
	}
	
	public Product getProductDetailsById(String id){
		ProductDO productDBO =  productRepo.findOneByuniqueId(id); 
		return productDBO!=null ? productDBO.toIO() : null;
		
	}
	
	public String addProduct(Product product){
		ProductDO productDBO = new ProductDO();
		if(product!=null){
			productDBO = product.toDBO();
			productRepo.insert(productDBO);
		}
		return productDBO.getUniqueId();
		
	}

}
