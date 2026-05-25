package com.example.apirest.dto;
import com.example.apirest.model.Producto;
public record ProductoDto (
    Long id, String nombre, Double precio
) {
    public static ProductoDto toDto (Producto p){
        if(p == null){
            return null;
        }
        return new ProductoDto(p.getId(), p.getNombre(), p.getPrecio());
    }

    public Producto toEntity (){
        Producto p = new Producto();
        p.setId(this.id());
        p.setNombre(this.nombre);
        p.setPrecio(this.precio());
        /* 
        Producto p = new Producto(
            p.setId(this.id()),  
            p.setNombre(this.nombre()), 
            p.setPrecio(this.precio()));*/

            return p;
    }
}
