package main.java.com.fundamentos.jpa.fundamentos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    private long id;
}
