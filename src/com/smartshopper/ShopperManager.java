 package com.smartshopper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.smartshopper.repository.ProductMongoRepository;
import com.smartshopper.repository.StoreMongoRepository;

@SpringBootApplication

public class ShopperManager{

	//@Autowired
	//private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ShopperManager.class, args);
	}
}