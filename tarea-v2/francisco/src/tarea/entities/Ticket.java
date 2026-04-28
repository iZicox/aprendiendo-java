package tarea.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ticket implements Comparable<Ticket>{
	private long id;
	private LocalDateTime fechaHora;
	private boolean ticketCerrado;
	private List<LineaTicket> lineaTicket;
	
	public Ticket(long id, LocalDateTime fechaHora, boolean ticketCerrado) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.ticketCerrado = ticketCerrado;
		this.lineaTicket = new ArrayList<LineaTicket>();
	}
	
	public Ticket(long id, LocalDateTime fechaHora, boolean ticketCerrado, List<LineaTicket> lineaTicket) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.ticketCerrado = ticketCerrado;
		this.lineaTicket = lineaTicket;
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

	public List<LineaTicket> getLineaTicket() {
		return lineaTicket;
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
		return Long.compare(this.getId(), o.getId());
	}

	@Override
	public String toString() {
		return "Ticket (" + id + ") " + fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - Estado: " + (ticketCerrado ? "Cerrado" : "Abierto") + ".";
	}

	
	
	
	
	
}
