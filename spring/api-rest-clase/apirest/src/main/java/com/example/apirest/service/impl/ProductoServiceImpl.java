package com.example.apirest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apirest.dto.ProductoDto;
import com.example.apirest.model.Producto;
import com.example.apirest.repository.ProductoRepository;
import com.example.apirest.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ProductoDto> listarTodo() {
        return repository.findAll().stream()
                .map(ProductoDto::toDto)
                .toList();

    }

    @Transactional(readOnly = true)
    public Optional<ProductoDto> buscarPorId(Long id) {
        return repository.findById(id).map(ProductoDto::toDto);
    }

    @Transactional
    public ProductoDto guardar(ProductoDto productoDTO) {
        Producto producto = productoDTO.toEntity();
        return ProductoDto.toDto(repository.save(producto));
    }

    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public ProductoDto actualizar(Long id, ProductoDto dto) {
        return repository.findById(id)
                .map(p -> {
                    p.setNombre(dto.nombre());
                    p.setPrecio(dto.precio());
                    return ProductoDto.toDto(repository.save(p));
                })
                .orElseThrow(() -> new RuntimeException("No existe el producto con ID: " + id));
    }

}
