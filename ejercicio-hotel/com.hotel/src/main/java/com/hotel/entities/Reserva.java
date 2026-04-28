package com.hotel.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva implements Comparable<Reserva>{
	private long id;
	private LocalDateTime entrada;
	private LocalDateTime salida;
	private Habitacion habitacion;
	private Cliente cliente;
	
	public Reserva(LocalDateTime entrada, LocalDateTime salida, Habitacion habitacion, Cliente cliente) {
		super();
		this.entrada = entrada;
		this.salida = salida;
		this.habitacion = habitacion;
		this.cliente = cliente;
	}
	
	public Reserva(long id, LocalDateTime entrada, LocalDateTime salida, Habitacion habitacion, Cliente cliente) {
		this(entrada, salida, habitacion, cliente);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSalida() {
		return salida;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public Cliente getCliente() {
		return cliente;
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
		Reserva other = (Reserva) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(Reserva o) {
		// TODO Auto-generated method stub
		return Long.compare(this.id, o.getId());
	}
	
	
	

}
