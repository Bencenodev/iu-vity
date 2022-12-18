package com.iuvity.store.application.service;

import java.util.List;

import com.iuvity.store.application.repository.ProductRepository;
import com.iuvity.store.domain.Product;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;

	public Product getProduct(Long id){
		return productRepository.findById(id);
	}
	
	public void saveProduct(Product product){
	 productRepository.saveProduct(product);
	}
	
	public List<Product> getAllProduct(){
		 return productRepository.getAllProduct();
	}
	
	public void updateProduct(Long id , Product product){productRepository.updateProduct(id, product);}
	
		
}
