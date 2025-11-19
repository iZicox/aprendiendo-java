package Ejercicio_05;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perro mascota = new Perro();

		mostrarPerro(mascota);

		System.out.println();

		mascota.setEdad(7);
		mascota.setNombre("Lassie");
		mascota.setPeso(22.62);
		mascota.setPropietario("Martin Smith");
		mascota.setRaza("Rough Collie");

		mostrarPerro(mascota);

		System.out.println();
		mascota.setPropietario("Mary peterson");

		mostrarPerro(mascota);

		System.out.println("comida");

		mascota.comer(200);

		System.out.printf("El nuevo peso es %.2f", mascota.getPeso());

		System.out.println("jugar");

		mascota.jugar(10);

		System.out.printf("El nuevo peso es %.2f", mascota.getPeso());
		
		System.out.println(mascota.getPosicion());
		
		System.out.println("******************************************************");
		System.out.println("POSICIONES");
		
		mascota.tumbarse();
		System.out.println(mascota.getPosicion());
		System.out.println("////////////////////");
		mascota.tumbarse();
		System.out.println(mascota.getPosicion());
		System.out.println("////////////////////");
		mascota.ponerseDePie();
		System.out.println(mascota.getPosicion());
		System.out.println("////////////////////");
		mascota.sentar();
		System.out.println(mascota.getPosicion());
		System.out.println("////////////////////");
		mascota.sentar();
		System.out.println(mascota.getPosicion());
		System.out.println("////////////////////");
	}

	private static void mostrarPerro(Perro mascota) {
		System.out.printf("Nombre: %s%n", mascota.getNombre());
		System.out.printf("Raza: %s%n", mascota.getRaza());
		System.out.printf("Nombre del propietario: %s%n", mascota.getPropietario());
		System.out.printf("Edad: %d años%n", mascota.getEdad());
		System.out.printf("Peso: %.2f%n", mascota.getPeso());

	}

}
