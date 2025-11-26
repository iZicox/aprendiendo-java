package Ejercicio_06;

/**
 * Clase para gestionar pacientes de un nutricionista
 * Almacena informacion personal basica y calcula IMC a
 * partir de ella
 * 
 * @author Vespertino
 * @version 1.0
 * @see <a href="enforma.com">Mantante en forma con alegria</a>
 */

public class Persona {
	final int PESO_X_DEFECTO=0;
	final int ALTURA_X_DEFECTO=0;
	final String HOMBRE = "H";
	final String MUJER = "M";
	
	private String nombre;
	private int edad;
	private String dni;
	private String sexo;
	private double peso; //kg
	private int altura; //cm
	
	//constructores
	//con todos los atributos
	/**
	 * 
	 * @param nombre contiene el nombre del paciente
	 * @param edad edad
	 * @param dni que aveces es aleatorio
	 * @param sexo
	 * @param peso
	 * @param altura
	 */
	public Persona(String nombre, int edad, String dni, String sexo, double peso, int altura) {
		this.nombre=nombre;
		this.edad=edad;
		this.dni=dni;
		this.sexo=sexo;
		this.peso=peso;
		this.altura=altura;
	}
	//sin atributos
	public Persona() {
		this.nombre="";
		this.edad=0;
		this.dni=dniAleatorio();
		this.sexo=MUJER;
		this.peso=0;
		this.altura=0;
	}
	//con dni y nombre
	/**
	 * 
	 * @param dni
	 * @param nombre
	 */
	public Persona(String dni, String nombre) {
		this.nombre=nombre;
		this.edad=0;
		this.dni=dni;
		this.sexo=MUJER;
		this.peso=0;
		this.altura=0;
	}
	
	public Persona(String dni, String nombre, int edad, String sexo) {
		this.nombre=nombre;
		this.edad=edad;
		this.dni=dni;
		this.sexo=sexo;
		this.peso=0;
		this.altura=0;
	}

	
	//metodos
	/**
	 * Devuelve el imc del paciente
	 * @return
	 */
	public int calcularIMC() {
		double alturaM = (double)(this.altura/100.0);
		double imc = this.peso / Math.pow(alturaM, 2);
		if (imc >= 20 && imc < 25) {
			return 0;
		} else if(imc<20) {
			return -1;
		} else {
			return 1;
		}
	}
	public boolean esMayorDeEdad() {
		if(this.edad >= 18) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 
	 * @param sexo
	 */
	public void comprobarSexo(String sexo) {
		if(this.sexo.equals(sexo)) {
			System.out.println("Si es un valor correcto.");
		} else {
			System.out.println("No es un valor correcto.");
		}
	}
	private String dniAleatorio() {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int numero = (int)(Math.random()*100000000);
		char letra = letras.charAt(numero%23);
		StringBuilder resultado = new StringBuilder();
		resultado.append(numero).append(letra);
		return resultado.toString();
	}
}
