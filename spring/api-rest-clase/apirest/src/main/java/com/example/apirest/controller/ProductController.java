package com.example.apirest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.dto.ProductoDto;
import com.example.apirest.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductController {

    private final ProductoService service; // inyeccion de dependencia

    public ProductController(ProductoService service) { // por constructor
        this.service = service;
    }

    // obtener todos
    @GetMapping
    public List<ProductoDto> obtenerTodos() {
        return service.listarTodo();
    }

    // crear
    @PostMapping
    public ResponseEntity<ProductoDto> guardar(@RequestBody ProductoDto productoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(productoDTO));
    }

    // obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(productoDTO -> ResponseEntity.ok(productoDTO)) // Si existe, devuelve 200 + DTO
                .orElse(ResponseEntity.notFound().build()); // Si es vacío, devuelve 404
    }

    // eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoDto> eliminarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(productoDTO -> {
                    service.eliminar(id); // Llama a la lógica de negocio para borrar [1, 2]
                    return ResponseEntity.ok(productoDTO); // Devuelve 200 OK y el DTO del producto eliminado [3, 4]
                })
                .orElse(ResponseEntity.notFound().build()); // Devuelve 404 si el ID no existe [3, 4]
    }

    // actualizar
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizar(@PathVariable Long id, @RequestBody ProductoDto productoDTO) {
        try {
            ProductoDto actualizado = service.actualizar(id, productoDTO);
            return ResponseEntity.ok(actualizado); // Devuelve 200 OK con el producto actualizado
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si el ID no existe
        }
    }
}
