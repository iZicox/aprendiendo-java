package Ejercicio_04_02;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perro mascota = new Perro("Firulais","Pastor aleman","Pepe",3,50.0);

		mostrarPerro(mascota);

		System.out.println();
		
		System.out.println(mascota.getPosicion().toString().toLowerCase()+5);

		
	
		String hola = "hola";
		
	

	}

	private static void mostrarPerro(Perro mascota) {
		System.out.printf("Nombre: %s%n", mascota.getNombre());
		System.out.printf("Raza: %s%n", mascota.getRaza());
		System.out.printf("Nombre del propietario: %s%n", mascota.getPropietario());
		System.out.printf("Edad: %d años%n", mascota.getEdad());
		System.out.printf("Peso: %.2f%n", mascota.getPeso());

	}

}
