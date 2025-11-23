package Ejercicio_09;

public class Main {
	public static void main(String[] args) {
		CuentaBancaria cuentaPepe = new CuentaBancaria("123456478A", "Pepe", "Gonzales",100);
		System.out.println(cuentaPepe.toString());
		cuentaPepe.reembolsar(00);
		
 	}

}

 