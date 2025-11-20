package Ejercicio_06;

public class Persona {
	final char HOMBRE = 'H';
	final char MUJER = 'M';
	
	String nombre;
	int edad;
	String dni;
	char sexo;
	double peso; //kg
	int altura; //cm
	
	//constructores
	public Persona() {
		this.nombre="";
		this.edad=0;
		this.dni=dniAleatorio();
		this.sexo=MUJER;
		this.peso=0;
		this.altura=0;
	}
	public Persona(String dni, String nombre) {
		this.nombre=nombre;
		this.edad=0;
		this.dni=dni;
		this.sexo=MUJER;
		this.peso=0;
		this.altura=0;
	}
	public Persona(String dni, String nombre, int edad, char sexo) {
		this.nombre=nombre;
		this.edad=edad;
		this.dni=dni;
		this.sexo=sexo;
		this.peso=0;
		this.altura=0;
	}
	public Persona(String nombre, int edad, String dni, char sexo, double peso, int altura) {
		this.nombre=nombre;
		this.edad=edad;
		this.dni=dni;
		this.sexo=sexo;
		this.peso=peso;
		this.altura=altura;
	}
	
	//metodos
	public double calcularIMC() {
		double imc = this.peso / (Math.pow((this.altura/100), 2));
		if(imc<20) {
			return -1;
		} else if (imc >= 20 && imc < 25) {
			return 0;
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
	public void comprobarSexo(char sexo) {
		if(this.sexo==sexo) {
			System.out.println("Si es un valor correcto.");
		} else {
			System.out.println("No es un valor correcto.");
		}
	}
}
