package com.iuvity.store.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="product")
public class ProductEntity {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
	
    @Column(name="name_product")
	private String name;
    
    @Column(name="description")
	private String description;
    
    @Column(name="price")
	private double price;

    @Column(name="existence")
    private int existence;



	
	
}
