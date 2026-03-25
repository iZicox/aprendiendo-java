package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Prestamo {
	private static int id = 1;
	/**
	 * Un Prestamo relaciona un socio con un fondo bibliográfico e incluye la fecha de préstamo y la fecha de devolución prevista (ambas LocalDate). Un préstamo activo no tiene fecha de devolución real; cuando se devuelve, se registra dicha fecha.
	 * 
	 */
	private int idPrestamo;
	private Socio socio;
	private FondoBibliografico fondoBibli;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucionPrevista;
	private LocalDate fechaDevolucionReal;
	
	/**
	 * 
	 * @param socio
	 * @param fondoBibli
	 * @param fechaDevolucionPrevista
	 */
	public Prestamo(Socio socio, FondoBibliografico fondoBibli,
			LocalDate fechaDevolucionPrevista) throws NullPointerException, IllegalArgumentException{
		super();
		if(socio == null) {
			throw new NullPointerException("El socio no puede ser nulo.");
		}
		if(fondoBibli == null) {
			throw new NullPointerException("El fondo bibliografico no puede ser nulo.");
		}
		this.fechaPrestamo = LocalDate.now();
		if(this.fechaPrestamo.isAfter(fechaDevolucionPrevista)) {
			throw new IllegalArgumentException("La devolucion debe ser una fecha mayor a la del prestamo.");
		}
		this.idPrestamo = id++;
		this.socio = socio;
		this.fondoBibli = fondoBibli;
		this.fechaDevolucionPrevista = fechaDevolucionPrevista;
	}
	
	public Prestamo(Prestamo prestamo) {
		this(
				prestamo.getSocio(),
				prestamo.getFondoBibli(),
				prestamo.getFechaDevolucionPrevista());
	}
	
	public void devolver() {
		this.fechaDevolucionReal = LocalDate.now();
	}
	
	public boolean prestamoAbierto() {
		return this.fechaDevolucionReal == null;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}
	public Socio getSocio() {
		return new Socio(socio);
	}

	public FondoBibliografico getFondoBibli() {
		return fondoBibli;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public LocalDate getFechaDevolucionPrevista() {
		return fechaDevolucionPrevista;
	}

	public LocalDate getFechaDevolucionReal() {
		return fechaDevolucionReal;
	}

	@Override
	public String toString() {
		return "ID: " + idPrestamo + ". Carnet: " + socio.getNumCarnet() + ". ISBN: " + fondoBibli.getIsbn()
				+ ". Fecha: " + fechaPrestamo.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + ". Devolucion: " + fechaDevolucionPrevista.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	}
	
	
	
	
	
	
}
