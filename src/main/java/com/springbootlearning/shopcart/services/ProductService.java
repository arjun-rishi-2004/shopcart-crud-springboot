package com.springbootlearning.shopcart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootlearning.shopcart.models.Product;
import com.springbootlearning.shopcart.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		System.out.println("Test: " +  productRepository.findAll());
		return productRepository.findAll();
	}
	
	public Optional<Product> getProduct(Long id) {
		return productRepository.findById(id);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	

	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}
}

