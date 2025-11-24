package Ejercicio_10;
/*
 UT 04 – Desarrollo de clases – Ejercicios
Ejercicio 10
Crea una clase Rectángulo, según estas especificaciones:
● Atributos:
o Base y altura. Serán números enteros, mayores que cero.
o Una vez creado el rectángulo, sus dimensiones (base y altura) se podrán
consultar, pero no modificar.
● Constructores:
o Un constructor que recibe la base y la altura.
o Un constructor que recibe solo el lado. Se usa para construir cuadrados
(consideramos un cuadrado como un caso particular de un rectángulo)
o Al crear los rectángulos, si se introduce la base y/o la altura <= 0, el valor
erróneo se sustituirá por 1, y se mostrará un mensaje en la consola de error
(System.err), indicando el problema.
● Métodos:
o Método para calcular el perímetro de la figura.
o Método para calcular el área de la figura.
o Método esMasAlto: recibe otro rectángulo y devuelve true si el rectángulo
tiene más altura que el recibido como parámetro.
o Método esMasAncho: recibe otro rectángulo y devuelve true si el rectángulo
tiene una base más grande que el recibido como parámetro.
o Método compararArea: recibe otro rectángulo, y devuelve:
▪ -1 si el área del rectángulo es menor que la del rectángulo parámetro.
▪ 0 si las áreas de los dos rectángulos son iguales.
▪ 1 si el área del rectángulo es mayor que la del rectángulo parámetro, o
si el parámetro es null.

Crear un programa principal que:
● Pregunte al usuario la base y altura de un rectángulo y cree un objeto con esos datos.
● Pregunte al usuario la base y altura para un segundo rectángulo y cree otro objeto.
● Muestre:
o Área y perímetro del primer rectángulo.
o Área y perímetro del segundo rectángulo.
o Una frase indicando cuál de los dos es más alto.
o Una frase indicando cuál de los dos es más ancho.
o Una frase indicando cuál de los dos tiene más área.
 * */
public class Rectangulo {
	//atributos
	private int base;
	private int altura;
	
	//constructores
	public Rectangulo(int base, int altura) {
		if (base <= 0) {
			System.err.println("Error: La base debe ser mayor que cero.");
			this.base=1;
		} else {
			this.base=base;
		}
		if (altura <= 0) {
			System.err.println("Error: La altura debe ser mayor que cero.");
			this.altura=1;
		} else {
			this.altura=altura;
		}
		
	}
	public Rectangulo(int lado) {
		if(lado <= 0) {
			System.err.println("Error: El lado debe ser mayor que cero.");
			this.base=1;
		} else {
			this.base=lado;
			this.altura=lado;
		}
	}
	
	//metodos
	public int perimetro() {
		return 2*this.base+2*this.altura;
	}
	public int area() {
		return this.base*this.altura;
	}
	public boolean EsMasAlto(Rectangulo nuevo) {
		return this.altura > nuevo.altura;
	}
	public boolean EsMasAncho(Rectangulo nuevo) {
		return this.base > nuevo.base;
	}
	public int comprarArea(Rectangulo nuevo) {
		if((area()>nuevo.area()) || (nuevo == null)) {
			return 1;
		} else if (area()<nuevo.area()) {
			return -1;
		} else {
			return 0;
		}
	}
}
