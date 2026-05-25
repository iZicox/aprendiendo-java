package com.example.apirest.service.impl;

import org.springframework.stereotype.Service;

import com.example.apirest.repository.ProductoRepository;

@Service
public class ProductoServiceImpl {

    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository){
        this.repository = repository;
    }

}
