package Ejercicios_UT04_Clases;

public class Rectangulo {
	
	public static final String NOMBRE_FIGURA = "Rectangulo";
	
	//vertice 1
	private int x1;
	private int y1;
	//tambien puede ser
	//private Punto p1;
	//private Punto p2;
	//vertice 2
	private int x2;
	private int y2;
	//nombre
	private String nombre;
	//numero de rectangulos
	private static int numeroRectangulos;
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static int getNumeroRectangulos() {
		return numeroRectangulos;
	}
	
	
	//metodos
	public int calcularSuperficie() {
		int superficie = 0;
		int base = x2 - x1;
		int altura = y2 - y1;
		superficie = base * altura;
		return superficie;
	}
	
	public int calcularPerimetro() {
		int perimetro = 0;
		int base = x2 - x1;
		int altura = y2 - y1;
		perimetro = 2 * (base+altura);
		return perimetro;
	}
	
	
	
	
	
}
