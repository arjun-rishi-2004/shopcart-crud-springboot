package com.springbootlearning.shopcart.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootlearning.shopcart.models.Product;
import com.springbootlearning.shopcart.services.ProductService;



@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts() {
	 
		return productService.getAllProducts();

		
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProduct(@PathVariable Long id) {
		
		return productService.getProduct(id);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		System.out.println("ID:" + id);
		productService.deleteProduct(id);
		return "Product Deleted";
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		
		System.out.println(product);
		
		return productService.saveProduct(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable long id , @RequestBody Product updatedProduct) {
		
		Optional<Product> existingProduct = productService.getProduct(id);
		if(existingProduct.isPresent()) {
			Product product = existingProduct.get();
			 product.setName(updatedProduct.getName());
		        product.setPrice(updatedProduct.getPrice());
		        product.setDescription(updatedProduct.getDescription());
		        product.setRatings(updatedProduct.getRatings());
		        product.setCategory(updatedProduct.getCategory());
		        product.setSeller(updatedProduct.getSeller());
		        product.setStock(updatedProduct.getStock());
		        product.setNumOfReviews(updatedProduct.getNumOfReviews());
		        product.setImages(updatedProduct.getImages());
			
		
		
		return productService.saveProduct(product);
		}
		else {
		return null;
		}
	}
	
	
	
	
}
