package Ejercicio_07;
/*
 * UT 04 – Desarrollo de clases – Ejercicios
Ejercicio 07
Crea una clase llamada CuentaBancaria según las siguientes especificaciones.
● Debe tener un número de cuenta, entre 1000000 y 9999999, que se genera
aleatoriamente al crearla.
● Debe guardar datos del titular de la cuenta: NIF, Nombre, Apellido
● Debe guardar la cantidad de dinero de la que se dispone en la cuenta. Será un número
que representa euros, con decimales.
● Debe permitir instanciar un objeto de tipo CuentaBancaria de dos formas diferentes:
o Recibiendo sólo los datos del titular, y fijando la cantidad de dinero a 0€.
o Recibiendo los datos del titular y la cantidad con la que se abre la cuenta.
● Una vez creada la cuenta ninguno de los atributos podrá modificarse.
● Implementa el método “toString” de la clase, para poder mostrar los datos por
consola. Este método:
o Debe devolver una cadena de texto con dos líneas. Para poder separar líneas
puedes usar ‘\n’
o Primera línea: Cuenta <nº de cuenta>. Saldo: <saldo>
o Segunda línea: Titular: <NIF/NIE> - <Nombre> <Apellido>
Haz un programa que cree cuentas de distintas formas y muestre los datos de estas cuentas
por consola
 * */
public class CuentaBancaria {
	//atributos
	private int numeroCta;
	private String nombre;
	private String apellido;
	private String nif;
	private double saldo;
	
	//constructores
	public CuentaBancaria(String nif, String nombre, String apellido){
			this.numeroCta=generarCta();
			this.nombre=nombre;
			this.apellido=apellido;
			this.nif=nif;
			this.saldo=0;
	}
	public CuentaBancaria(String nif, String nombre, String apellido, double saldo) {
			this.numeroCta=generarCta();
			this.nombre=nombre;
			this.apellido=apellido;
			this.nif=nif;
			this.saldo=saldo;
	}
	
	//metodos
	private int generarCta() {
		return (int)(Math.random()*1000000);
	}
	public String toString() {
		return "Numero de cuenta: " + this.numeroCta + ". Saldo: " + this.saldo + "\n" +
				"Titular: " + this.nif + " - " + this.nombre + " " + this.apellido;
	}
}
