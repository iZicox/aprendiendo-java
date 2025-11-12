package Ejercicios_UT04_Clases;
/**
 * Ejemplo clase punto
 */

// los nombres de las clases siempre empiezan en mayusculas
public class Punto {
	//atributos (siempre son privados)
	// suelen llamarse con un sustantivo
	int x;
	int y;
	// metodos (para acceder y modificar los atributos)
	// suelen llamarse como un verbo
	int obtenerX() {
		return x;
	}
	int obtenerY() {
		return y;
	}
	void modificarX(int vX) {
		x = vX;
	}
	void modificarY(int vY) {
		y = vY;
	}
	

}
