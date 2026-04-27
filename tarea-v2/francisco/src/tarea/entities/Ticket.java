package tarea.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket implements Comparable<Ticket>{
	private long id;
	private LocalDateTime fechaHora;
	private boolean ticketCerrado;
	
	public Ticket(long id, LocalDateTime fechaHora, boolean ticketCerrado) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.ticketCerrado = ticketCerrado;
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public boolean isTicketCerrado() {
		return ticketCerrado;
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
		Ticket other = (Ticket) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(Ticket o) {
		// TODO Auto-generated method stub
		return this.getId;
	}
	
	
	
	
}
