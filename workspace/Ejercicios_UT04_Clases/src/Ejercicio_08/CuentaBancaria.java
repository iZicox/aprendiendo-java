package Ejercicio_08;
/*
 * Modifica la clase anterior para que puedan realizarse las siguientes acciones:
● Reembolsar dinero: reduce la cantidad de dinero de la cuenta en la cantidad que se
reciba como parámetro. De momento, el saldo de la cuenta puede pasar a negativo.
● Ingresar dinero: aumenta la cantidad de la cuenta en la cantidad que reciba como
parámetro.
● Consultar saldo: permite consultar el saldo de la cuenta
● Consultar si la cuenta está en números rojos (saldo negativo). No devuelve el saldo,
sólo indica si está o no en números rojos.
Modifica el programa principal para que se prueben los nuevos métodos.
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
	public void reembolsar(double reembolso) {
		this.saldo -= reembolso;
	}
	public void ingresar(double ingreso) {
		this.saldo += ingreso;
	}
	public void consultarSaldo() {
		if(this.saldo >= 0) {
			System.out.println("Tu cuenta esta en positivo");
		} else {
			System.out.println("Tu cuenta esta en negativo");
		}
	}
}
