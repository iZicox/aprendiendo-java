package com.manolo;

public class Administrador extends Usuario {

    public Administrador(String nombre, String password) {
        super(nombre, password);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Administrador: " + this.getNombre() + " - " + this.getPassword();
    }

    

}
