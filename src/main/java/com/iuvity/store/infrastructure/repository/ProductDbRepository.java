package com.iuvity.store.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iuvity.store.infrastructure.entity.ProductEntity;

@Repository
public interface ProductDbRepository extends JpaRepository<ProductEntity,Long>{
	
	

}
