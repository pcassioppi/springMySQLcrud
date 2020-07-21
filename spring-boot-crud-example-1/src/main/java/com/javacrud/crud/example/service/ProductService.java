package com.javacrud.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacrud.crud.example.repository.ProductRepository;
import com.javacrud.crud.example.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	//saves product
	public Product saveProduct(Product product) {		
		return repository.save(product);
	}//saves list of products
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	//returns all the products available in database
	public List<Product> getProducts(){
		return repository.findAll();
	}
	//returns product by id
	public Product getProductById(int id){
		return repository.findById(id).orElse(null);
	}
	//returns product by name
	public Product getProductByName(String name){
		return repository.findByName(name);
	}
	//deletes product by id
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product deleted: "+id;
	}
	//updates product found with id
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}

}
