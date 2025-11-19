package Teoria_UT04_Clases;
/**
 * Ejemplo clase punto
 */

// los nombres de las clases siempre empiezan en mayusculas
public class Punto {
	//atributos (siempre son privados)
	// suelen llamarse con un sustantivo
	private int x;
	private int y;
	// metodos (para acceder y modificar los atributos)
	// suelen llamarse como un verbo
	public Punto(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public Punto(Punto xy) {
		this.x=xy.obtenerX();
		this.y=xy.obtenerY();
	}
	public Punto() {
		
	}
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
