package com.iuvity.store.application.repository;

import java.util.List;

import com.iuvity.store.domain.Product;

public interface ProductRepository {

	 Product findById(Long id);
		
	 void saveProduct(Product product);
	
	 List<Product> getAllProduct();

	 void updateProduct(Long id, Product product);
	
}
