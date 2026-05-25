package com.spring.jpa.practica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto,Long> {

    //consultas usando nombre del metodo
    List<Producto> findByPrecio(double precio);
    List<Producto> findByNombre(String nombre);
    List<Producto> findByNombreIgnoreCase(String nombre);

    //jpql parecido a sql
    @Query("""
            select p 
            from Producto p
            where p.nombre like %?1%
            """)
    List<Producto> listaPorNombre(String nombre);

    @Query("""
            select p from Producto p
            where p.precio between :min and :max
            """)
    List<Producto> productosPorPrecio(double min, double max);
    
}
