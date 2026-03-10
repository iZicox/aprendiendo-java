package ejercicio_03;

import java.time.LocalDate;

public class Cliente {
	private String documento;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNac;
	private String email;
	
	public Cliente(String documento, String nombre, String apellidos, LocalDate fechaNac, String email) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.email = email;
	}
	
	public Cliente(Cliente cliente) {
		this.documento = cliente.getDocumento();
		this.nombre = cliente.getNombre();
		this.apellidos = cliente.getApellidos();
		this.fechaNac = cliente.getFechaNac();
		this.email = cliente.getEmail();
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Documento: " + documento + ". Nombre: " + nombre + ". Apellidos: " + apellidos + ". Fecha nacimiento: "
				+ fechaNac + ". Email: " + email + ".";
	}
	
	
	
}
