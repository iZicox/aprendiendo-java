package com.hotel.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class CheckIn implements Comparable<CheckIn> {
	private long id;
	private LocalDateTime entrada;
	private LocalDateTime salida;
	private Realizado realizado;
	private Reserva reserva;
	
	public CheckIn(LocalDateTime entrada, LocalDateTime salida, Realizado realizado, Reserva reserva) {
		super();
		this.entrada = entrada;
		this.salida = salida;
		this.realizado = realizado;
		this.reserva = reserva;
	}
	
	public CheckIn(long id, LocalDateTime entrada, LocalDateTime salida, Realizado realizado, Reserva reserva) {
		this(entrada, salida, realizado, reserva);
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

	public Realizado getRealizado() {
		return realizado;
	}

	public Reserva getReserva() {
		return reserva;
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
		CheckIn other = (CheckIn) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(CheckIn o) {
		// TODO Auto-generated method stub
		return Long.compare(this.id, o.getId());
	}
	
	
	
}
