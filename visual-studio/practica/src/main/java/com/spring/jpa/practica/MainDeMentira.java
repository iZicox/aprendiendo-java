package com.spring.jpa.practica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MainDeMentira {
    
    @Autowired
    private ProductoRepository repo;

    @PostConstruct
    public void run(){
        // ejemplo de insertar una registro
        Producto p = new Producto(null, "un producto", 120.50);
        System.out.println("hola");
        repo.save(p);

    }
}
