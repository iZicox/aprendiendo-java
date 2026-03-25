package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Socio {
	private String numCarnet;
	private String nombre;
	private LocalDate fechaAlta;
	private int limitePrestamoSimultaneo;
	private ArrayList<Prestamo> prestamosActivos;
	
	
	/**
	 * 
	 * @param numCarnet
	 * @param nombre
	 * @param limitePrestamoSimultaneo
	 */
	public Socio(	String numCarnet, 
					String nombre, 
					int limitePrestamoSimultaneo) 	throws 	NullPointerException, 
															IllegalArgumentException {
		super();
		if(numCarnet.isBlank() || numCarnet == null) {
			throw new NullPointerException("El carnet no puede ser nulo");
		}
		if(nombre.isBlank() || nombre == null) {
			throw new NullPointerException("El nombre no puede ser nulo");
		}
		if(limitePrestamoSimultaneo <= 0) {
			throw new IllegalArgumentException("El limite no puede ser menor a cero.");
		}
		this.numCarnet = numCarnet;
		this.nombre = nombre;
		this.fechaAlta = LocalDate.now();
		this.limitePrestamoSimultaneo = limitePrestamoSimultaneo;
		this.prestamosActivos = new ArrayList<Prestamo>();
	}
	
	/**
	 * de copia
	 * @param socio
	 */
	public Socio(Socio socio) {
		this(
				socio.getNumCarnet(),
				socio.getNombre(),
				socio.getLimitePrestamoSimultaneo());
	}
	
	public void pedirFondo(Prestamo prestamo) {
		if(this.prestamosActivos.size() < limitePrestamoSimultaneo) {
			this.prestamosActivos.add(new Prestamo(prestamo));
		}else {
			System.out.println("No se aceptan mas prestamos para este socio.");
		}
	}
	
	public void eliminarPrestamo(int id) {
		Iterator<Prestamo> it = this.prestamosActivos.iterator();
		while(it.hasNext()) {
			Prestamo temp = it.next();
			if(temp.getIdPrestamo() == id) {
				it.remove();
				return;
			}
		}
		System.out.println("ID de prestamo no encontrado.");
	}
	
	

	public String getNumCarnet() {
		return numCarnet;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public int getLimitePrestamoSimultaneo() {
		return limitePrestamoSimultaneo;
	}
	
	public ArrayList<Prestamo> getPrestamosActivos() {
		ArrayList<Prestamo> copia = new ArrayList<Prestamo>(this.prestamosActivos);
		return copia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numCarnet);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return Objects.equals(numCarnet, other.numCarnet);
	}

	@Override
	public String toString() {
		return "Carnet: " + numCarnet 
				+ ". Nombre: " + nombre 
				+ ". Alta: " + fechaAlta.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"))
				+ ". Limite: " + limitePrestamoSimultaneo + ".";
	}
	
	public static class CompararNombre implements Comparator<Socio>{

		@Override
		public int compare(Socio o1, Socio o2) {
			// TODO Auto-generated method stub
			return o1.getNombre().compareToIgnoreCase(o2.getNombre());
		}
		
	}
	
	
	
	
}
