package com.courseTheory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.courseTheory.models.Product;
import com.courseTheory.repository.ProductRepository;



@Service
public class ProductService {
	
	private List<Product> list = new ArrayList<>();
	
	
	 @Autowired
	private ProductRepository  productRepository;
	 
	 
	
	// Create  ********
	public Product createProduct(Product product) {
		
		return productRepository.createProduct(product);
	}
	
	
	
	// Update  **********
	public Product updateProduct(Product p, int pid) {
		
		return  productRepository.updateProduct(p, pid);
	}
	
	
	
	
	// Delete by id ***********
	public void deleteProduct(int pid) {
		
		productRepository.deleteProduct(pid);
	}
	
	
	// Delete All ***********
	public void deleteAll() {
		
		list.clear();
	}
	
	
	
	// Get single Product  **********
	public Product getProduct(int pid) {
		
		return productRepository.getProduct(pid);
	}
	
	
	
	// Get all Product  **********
	public List<Product> getAllProducts(){
		
		
		return productRepository.getAllProducts();
	}

}
