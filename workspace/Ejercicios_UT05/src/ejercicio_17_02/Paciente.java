package ejercicio_17_02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Paciente implements Comparable<Paciente> {
	/**
	 * DNI (String).
○ Nombre completo (String).
○ Especialidad (Especialidad).
○ Síntomas (String).
○ Gravedad (Gravedad).
○ Fecha y Hora de llegada (LocalDateTime).
○ Importante: La clase debe implementar la interfaz
Comparable<Paciente> para definir que la prioridad se basa primero en
la gravedad y, si es la misma, en la fecha/hora de llegada más antigua.
	 */
	
	private String dni;
	private Especialidad especialidad;
	private String sintomas;
	private Gravedad gravedad;
	private LocalDateTime fechLlegada;
	
	public Paciente(String dni, Especialidad especialidad, Gravedad gravedad, String sintomas) {
		super();
		this.dni = dni;
		this.especialidad = especialidad;
		this.sintomas = sintomas;
		this.gravedad = gravedad;
		this.fechLlegada = LocalDateTime.now();
	}

	public Paciente(Paciente paciente) {
		this(
				paciente.getDni(),
				paciente.getEspecialidad(),
				paciente.getGravedad(),
				paciente.getSintomas());
	}
	public String getDni() {
		return dni;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public String getSintomas() {
		return sintomas;
	}
	
	public Gravedad getGravedad() {
		return gravedad;
	}

	public LocalDateTime getFechLlegada() {
		return fechLlegada;
	}

	@Override
	public String toString() {
		return "DNI: " + dni + ". Especialidad: " + especialidad + ". Sintomas: " + sintomas + ". Gravedad: " + gravedad +". Fecha llegada: "
				+ fechLlegada.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	}

	@Override
	public int compareTo(Paciente otro) {
		int comp =  this.getGravedad().compareTo(otro.getGravedad());
		if(comp != 0) {
			return comp;
		}
		comp = this.getFechLlegada().compareTo(otro.getFechLlegada());
		
		return comp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
	
	
}
