package Ejercicio_13;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehiculoMotor a = new Coche( "audi", "a1", 5);
		a.acelerar(10);
		a.acelerar(100);
		a.frenar(50);
		a.acelerar(100);
		a.frenar(200);
		System.out.println("********************");
		a = new Moto( "bera", "nose", 2);
		a.acelerar(10);
		a.acelerar(100);
		a.frenar(50);
		a.acelerar(100);
		a.frenar(200);
		
	}

}
