package Ejercicio_01;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perro mascota = new Perro();
		/*mascota.setEdad(4);
		mascota.setNombre("Firulais");
		mascota.setPeso(10.25);
		mascota.setPropietario("Juanito Alimaña");
		mascota.setRaza("Doberman");*/
		
		mostrarPerro(mascota);
		
		System.out.println();
		
		
		
	}
	
	private static void mostrarPerro(Perro mascota) {
		System.out.printf("Nombre: %s%n",mascota.getNombre());
		System.out.printf("Raza: %s%n",mascota.getRaza());
		System.out.printf("Nombre del propietario: %s%n",mascota.getPropietario());
		System.out.printf("Edad: %d%n",mascota.getEdad());
		System.out.printf("Peso: %.2f%n",mascota.getPeso());
		
	}
	


}
