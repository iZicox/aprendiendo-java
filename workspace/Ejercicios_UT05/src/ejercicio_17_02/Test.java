package ejercicio_17_02;

import java.util.Objects;
import java.util.PriorityQueue;

public class Test {
	
	public static class Persona{
		private String dni;
		private String nombre;
		
		public  Persona(String dni, String nombre) {
			this.dni = dni;
			this.nombre = nombre;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(dni);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Persona other = (Persona) obj;
			return Objects.equals(dni, other.dni);
		}
	}
	


	public static void main(String[] args) {
		
		Persona p1 = new Persona("123","juan");
		Persona p2 = new Persona("123","juan");
		System.err.println(p1.equals(p2));
	
    }


}
