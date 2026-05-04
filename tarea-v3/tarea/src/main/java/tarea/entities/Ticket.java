package tarea.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ticket {
	/*
	 * Name             Null?       Type            
________________ ___________ _______________ 
ID               NOT NULL    NUMBER(9)       
FECHAHORA        NOT NULL    TIMESTAMP(6)    
TICKETCERRADO    NOT NULL    VARCHAR2(1)  
	 */
	private long id;
	private LocalDateTime fechaHora;
	private TicketCerrado ticketCerrado;
	private List<LineaTicket> lineas;
	
	public Ticket(TicketCerrado ticketCerrado) {
		super();
		this.fechaHora = LocalDateTime.now();
		this.ticketCerrado = ticketCerrado;
		this.lineas = new ArrayList<LineaTicket>();
	}
	
	public Ticket(long id, Ticket ticket) {
		this(ticket.getTicketCerrado());
		this.id = id;
		this.fechaHora = ticket.getFechaHora();
		this.lineas = new ArrayList<LineaTicket>(ticket.getLineas());
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public TicketCerrado getTicketCerrado() {
		return ticketCerrado;
	}

	public List<LineaTicket> getLineas() {
		return lineas;
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
	
	
	
}
