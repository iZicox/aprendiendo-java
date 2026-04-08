package logica;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public abstract class Vehiculo implements Comparable<Vehiculo> {
	private String matricula;
	private String marca;
	private String modelo;
	private List<Intervencion> historial;
	
	/**
	 * 
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param historial
	 */
	public Vehiculo(String matricula, String marca, String modelo) {
		super();
		this.matricula = matricula.toUpperCase();
		this.marca = marca;
		this.modelo = modelo;
		this.historial = new LinkedList<Intervencion>();
	}
	
	/**
	 * Metodo para determinar el coste de los objetos que hereden de vehiculo
	 * @return
	 */
	public abstract double getCosteHora();
	
	/**
	 * Metodo para agregar una nueva intervencion al historial del vehiculo con copia defensiva
	 * @param i tipo intervencion
	 */
	public void nuevaIntervencion(Intervencion i) {
		Intervencion copia = new Intervencion(i);
		this.historial.add(copia);
	}
	
	

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	/**
	 * Getter para obtener el historial con copia defensiva
	 * @return
	 */
	public List<Intervencion> getHistorial() {
		LinkedList<Intervencion> copia = new LinkedList<Intervencion>(this.historial);
		return copia;
	}
	
	

	@Override
	public int compareTo(Vehiculo o) {
		return this.getMatricula().compareTo(o.getMatricula());
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return matricula + " - " + marca + " " + modelo;
	}
	
	
	
	
	
}
