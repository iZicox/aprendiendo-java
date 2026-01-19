package Ejercicio_04;
/*
 * UT 07 – Ejercicios
Ejercicio 04 – Jerarquía de clases: estructura laboral de una empresa
Crear las clases necesarias para implementar la siguiente jerarquía representada en UML:
La clase base es la clase Empleado. Esta clase contiene:
● Un atributo privado “nombre” de tipo String.
● Un constructor por defecto (sin parámetros).
● Un constructor con parámetros que inicializa el nombre con el String que recibe.
● Método set y get para el atributo nombre.
● Un método toString() que devuelve el String: "Empleado " + nombre
 * */
public abstract class Empleado {
	private String nombre;
	
	Empleado(){
		
	}
	
	Empleado(String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Nombre del empleado: " + this.nombre;
	}
	
	
}
