package Ejercicio_09;

/*

Modifica la clase anterior para implementar ciertas medidas de seguridad:

● Añade una propiedad para saber si la cuenta admite o no descubiertos (estar en
números rojos). Ten en cuenta que puede que tengas que cambiar o añadir
constructores para cubrir esta nueva propiedad.

● Los métodos para ingresar o reembolsar dinero deben controlar que la cantidad sea
mayor que cero. Si no lo es, no deben cambiar el saldo de la cuenta, y deben dejar un
mensaje por la consola indicándolo.

● El método para reembolsar dinero, además de lo anterior, si al retirar el dinero la
cuenta pasara a estar en números rojos, debe verificar si esa cuenta permite
descubiertos. Si no los permite, debe mantener el saldo (no cambiarlo), y mostrar un
mensaje por consola indicando que no se ha retirado el dinero porque no se puede
entrar en descubierto.

*/

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
		if(saldo <= 0) {
			System.out.println("El saldo debe ser mayor a cero.");
			return;
		}
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
		if(reembolso > saldo || reembolso == 0) {
			
			System.out.println("El reembolso debe ser mayor que cero.");
			
			System.out.println("El reembolso debe ser menor o igual al saldo actual.");
			return;
		}
		this.saldo -= reembolso;
	}
	public void ingresar(double ingreso) {
		if(ingreso > 0) {
			System.out.println("Ingreso debe ser mayor a cero.");
			return;
		}
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
