package com.example.apirest.service;

import java.util.List;
import java.util.Optional;

import com.example.apirest.dto.ProductoDto;

public interface ProductoService {
    List<ProductoDto> listarTodo();
    Optional<ProductoDto> buscarPorId(Long id);
    ProductoDto guardar (ProductoDto dto);
    void eliminar(Long id);
    ProductoDto actualizar (Long id, ProductoDto dto);

}
