package com.hotel.entities;

import java.util.Objects;

public class Cliente implements Comparable<Cliente>{
	private long id;
	private String dni;
	private String nombre;
	private String telefono;
	private String email;
	
	public Cliente(String dni, String nombre, String telefono, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	
	public Cliente(long id, String dni, String nombre, String telefono, String email) {
		this(dni, nombre, telefono, email);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", email="
				+ email + "]";
	}

	@Override
	public int compareTo(Cliente o) {
		// TODO Auto-generated method stub
		return Long.compare(this.id, o.getId());
	}
	
	

	
	
	
	
}
