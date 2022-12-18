package com.iuvity.store.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.iuvity.store.application.repository.ProductRepository;
import com.iuvity.store.domain.Product;
import com.iuvity.store.infrastructure.entity.ProductEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductDbImpRepository implements ProductRepository{
	
	private final ProductDbRepository productDbRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Product findById(Long id) {
		return modelMapper.map(productDbRepository.findById(id), Product.class);
	}

	@Override
	public void saveProduct(Product product) {
		productDbRepository.save(modelMapper.map(product, ProductEntity.class));
	}

	@Override
	public List<Product> getAllProduct() {
		List<ProductEntity> pe = productDbRepository.findAll();
		List<Product> p = new ArrayList<>();
		pe.forEach(pep-> p.add(modelMapper.map(pep, Product.class)));
		return p;
	}

	@Override
	public void updateProduct(Long id, Product product) {
		product.setId(id);
		productDbRepository.save(modelMapper.map(product, ProductEntity.class));
	}




}
