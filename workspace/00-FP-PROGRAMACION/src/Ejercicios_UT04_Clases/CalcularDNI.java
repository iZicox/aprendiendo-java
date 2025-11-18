package Ejercicios_UT04_Clases;

public class CalcularDNI {
	//atributos
	int numero;
	int letra;
	
	//constructores
	public CalcularDNI(int numero) {
		//verificar el numero
		if(numero < 0 || numero > 99999999) {
			System.out.println("Error: Ingresaste un numero equivocado.");
			return;
		}
		//declarar variables 
		this.numero = numero;
		this.letra = calcularLetra(numero);
	}
	public CalcularDNI(String nif) {
		if(nif.length() != 8){
			System.out.println("Error: Ingrese un NIF nuevamente");
		}
	}
	
	private int calcularLetra(int dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		char letraDNI = letras.charAt(dni % 23);
		return letraDNI;
	}
}
