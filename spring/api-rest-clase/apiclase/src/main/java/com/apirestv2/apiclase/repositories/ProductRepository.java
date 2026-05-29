package com.apirestv2.apiclase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestv2.apiclase.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
