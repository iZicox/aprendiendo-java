package ejercicio_02;

import java.time.LocalDate;

/**
 * Crea una clase Alumno que permita almacenar al menos el NIF/NIE, nombre, apellidos,
ciclo formativo, curso, fecha de nacimiento. Crea a tu discreción los constructores /
getters / setters que necesites. Sobrescribe el método toString para que sea más fácil
listar los alumnos.
 */
public class Alumno {
	private String nie;
	private String nombre;
	private String apellidos;
	private CicloFormativo cicloFormativo;
	private Curso curso;
	private LocalDate fechaNacimiento;
	
	
	public Alumno(String nie, String nombre, String apellidos, CicloFormativo cicloFormativo, Curso curso,
			LocalDate fechaNacimiento) {
		super();
		this.nie = nie;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cicloFormativo = cicloFormativo;
		this.curso = curso;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Alumno(Alumno alumno) {
		this.nie = alumno.getNie();
		this.nombre = alumno.getNombre();
		this.apellidos = alumno.getApellidos();
		this.cicloFormativo = alumno.getCicloFormativo();
		this.curso = alumno.getCurso();
		this.fechaNacimiento = alumno.getFechaNacimiento();
	}


	public String getNie() {
		
		return nie;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public CicloFormativo getCicloFormativo() {
		return cicloFormativo;
	}


	public Curso getCurso() {
		return curso;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		return "NIE: " + nie + ". Nombre: " + nombre + ". Apellidos: " + apellidos + ". Ciclo Formativo: "
				+ cicloFormativo + ". Curso: " + curso + ". Fecha Nacimiento: " + fechaNacimiento + ".";
	}
	
	
	
	

}
