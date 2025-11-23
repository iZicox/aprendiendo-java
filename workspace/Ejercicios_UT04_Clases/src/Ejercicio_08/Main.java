package Ejercicio_08;

public class Main {
	public static void main(String[] args) {
		CuentaBancaria cuentaPepe = new CuentaBancaria("123456478A", "Pepe", "Gonzales");
		System.out.println(cuentaPepe.toString());
		
		System.out.println("***********");
		
		cuentaPepe.ingresar(1000);
		System.out.println(cuentaPepe.toString());
		
		System.out.println("***********");
		
		cuentaPepe.reembolsar(5000);
		System.out.println(cuentaPepe.toString());
		
		System.out.println("***********");
		cuentaPepe.consultarSaldo();
		System.out.println(cuentaPepe.toString());
 	}

}

 