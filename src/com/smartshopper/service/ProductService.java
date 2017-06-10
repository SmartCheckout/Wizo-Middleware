package com.smartshopper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshopper.models.dbo.ProductDBO;
import com.smartshopper.models.io.Product;
import com.smartshopper.repository.ProductMongoRepository;

@Service
public class ProductService {

	@Autowired
	private ProductMongoRepository productRepo;

	public Product getProductDetailsBySKU(String sku){
		ProductDBO productDBO =  productRepo.findOneBybarcode(sku); 
		return productDBO.toIO();
	}
	
	public Product getProductDetailsById(String id){
		ProductDBO productDBO =  productRepo.findOneByuniqueId(id); 
		return productDBO.toIO();
		
	}
	
	public String addProduct(Product product){
		ProductDBO productDBO = new ProductDBO();
		if(product!=null){
			productDBO = product.toDBO();
			productRepo.insert(productDBO);
		}
		return productDBO.getUniqueId();
		
	}

}
