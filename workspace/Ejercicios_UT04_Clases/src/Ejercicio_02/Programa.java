package Ejercicio_02;

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
		
		
		
	}
	
	private static void mostrarPerro(Perro mascota) {
		System.out.printf("Nombre: %s%n",mascota.getNombre());
		System.out.printf("Raza: %s%n",mascota.getRaza());
		System.out.printf("Nombre del propietario: %s%n",mascota.getPropietario());
		System.out.printf("Edad: %d años%n",mascota.getEdad());
		System.out.printf("Peso: %.2f%n",mascota.getPeso());
		
	}
	


}
