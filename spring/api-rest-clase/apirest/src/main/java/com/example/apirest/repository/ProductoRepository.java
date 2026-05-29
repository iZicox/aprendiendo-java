package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
    

}
