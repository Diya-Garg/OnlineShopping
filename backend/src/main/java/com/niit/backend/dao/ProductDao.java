package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.dto.Product;


public interface ProductDao {
	
	boolean insertProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(int productId);
	public Product getProductById(int productId);
	List<Product> getProducts();
}