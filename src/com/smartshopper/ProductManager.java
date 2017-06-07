package com.smartshopper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductManager{

	//@Autowired
	//private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProductManager.class, args);
	}
}