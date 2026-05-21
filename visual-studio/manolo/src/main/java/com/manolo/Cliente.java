package com.manolo;

public class Cliente extends Usuario{

    public Cliente(String nombre, String password) {
        super(nombre, password);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Cliente: " + this.getNombre() + " - " + this.getPassword();
    }

    
}
