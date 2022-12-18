package com.iuvity.store.infrastructure.rest;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuvity.store.application.service.ProductService;
import com.iuvity.store.domain.Product;
import com.iuvity.store.infrastructure.dto.ProductDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
	
	private final ProductService productService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<ProductDto> getUserById(@PathVariable Long id) {
		return new ResponseEntity<>(modelMapper.map((productService.getProduct(id)), ProductDto.class), HttpStatus.OK);
	}

	@PostMapping("/producto")
	public ResponseEntity<ProductDto> saveUser(@RequestBody ProductDto productDto) {
		productService.saveProduct(modelMapper.map(productDto, Product.class));
		return new ResponseEntity<>( HttpStatus.CREATED);
	}
	
	
	@GetMapping("/productos")
	public ResponseEntity<List<ProductDto>> getProducts() {
		List<Product> pe = productService.getAllProduct();
		List<ProductDto> p = new ArrayList<>();
		pe.forEach(pep-> p.add(modelMapper.map(pep, ProductDto.class)));
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@PutMapping("producto/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id , @RequestBody ProductDto productDto){
		productService.updateProduct(id,modelMapper.map(productDto,Product.class));
		return new ResponseEntity<>( modelMapper.map((productService.getProduct(id)), ProductDto.class), HttpStatus.ACCEPTED);
	}

}
