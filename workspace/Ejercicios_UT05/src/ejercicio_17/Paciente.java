package ejercicio_17;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Paciente implements Comparable<Paciente>{
	private String dni;
	private String nombreCompleto;
	private Especialidad especialidad;
	private String sintomas;
	private Gravedad gravedad;
	private LocalDateTime fechaLlegada;
	
	public Paciente(String dni, String nombreCompleto, Especialidad especialidad, String sintomas, Gravedad gravedad,
			LocalDateTime fechaLlegada) {
		super();
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.especialidad = especialidad;
		this.sintomas = sintomas;
		this.gravedad = gravedad;
		this.fechaLlegada = fechaLlegada;
	}
	
	public Paciente(Paciente paciente) {
		this(paciente.getDni(),paciente.getNombreCompleto(),paciente.getEspecialidad(),paciente.getSintomas(),paciente.getGravedad(),paciente.getFechaLlegada());
	}

	public String getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
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

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	@Override
	public int compareTo(Paciente other) {
		int cmp = Integer.compare(this.gravedad.ordinal(), other.getGravedad().ordinal());
		if(cmp != 0) {
			return cmp;
		}
		return this.getFechaLlegada().compareTo(other.getFechaLlegada());
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - DNI: %s - %s - %s", 
				gravedad.toString(), 
				fechaLlegada.format(DateTimeFormatter.BASIC_ISO_DATE), 
				especialidad.toString(),
				dni,
				nombreCompleto,
				sintomas);
	}
	
	/*
	Importante: La clase debe implementar la interfaz
	Comparable<Paciente> para definir que la prioridad se basa primero en
	la gravedad y, si es la misma, en la fecha/hora de llegada más antigua
	 */
	
}
