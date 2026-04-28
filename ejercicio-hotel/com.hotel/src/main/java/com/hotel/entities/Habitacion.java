package com.hotel.entities;

import java.util.Objects;

public class Habitacion implements Comparable<Habitacion> {
	private long id;
	private int numero;
	private int planta;
	private Tipo tipo;
	private double precioNoche;
	private Estado estado;
	
	public Habitacion(int numero, int planta, Tipo tipo, double precioNoche, Estado estado) {
		super();
		this.numero = numero;
		this.planta = planta;
		this.tipo = tipo;
		this.precioNoche = precioNoche;
		this.estado = estado;
	}
	
	public Habitacion(long id, int numero, int planta, Tipo tipo, double precioNoche, Estado estado) {
		this(numero, planta, tipo, precioNoche, estado);
		this.id = id;
	}
	
	public Habitacion(long id, Habitacion hab) {
		this(hab.getNumero(), hab.getPlanta(), hab.getTipo(), hab.getPrecioNoche(), hab.getEstado());
		this.id = id;
	}
		

	public long getId() {
		return id;
	}

	public int getNumero() {
		return numero;
	}

	public int getPlanta() {
		return planta;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}

	public Estado getEstado() {
		return estado;
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
		Habitacion other = (Habitacion) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(Habitacion o) {
		// TODO Auto-generated method stub
		return Long.compare(this.id, o.getId());
	}
	
	
	
	
}
