package com.iuvity.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iuvity.store.application.repository.ProductRepository;
import com.iuvity.store.application.service.ProductService;

@Configuration
public class StoreApplicationConfig {

	 @Bean
	  public ProductService productService(ProductRepository productRepository) {
	    return new ProductService(productRepository);
	  }
	
}
