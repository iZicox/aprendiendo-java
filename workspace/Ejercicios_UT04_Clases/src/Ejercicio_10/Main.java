package Ejercicio_10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Crear un programa principal que:
● Pregunte al usuario la base y altura de un rectángulo y cree un objeto con esos datos.
● Pregunte al usuario la base y altura para un segundo rectángulo y cree otro objeto.
● Muestre:
o Área y perímetro del primer rectángulo.
o Área y perímetro del segundo rectángulo.
o Una frase indicando cuál de los dos es más alto.
o Una frase indicando cuál de los dos es más ancho.
o Una frase indicando cuál de los dos tiene más área.
 * */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa una altura: ");
		int altura = sc.nextInt();
		System.out.println("Ingresa una base: ");
		int base = sc.nextInt();
		Rectangulo uno = new Rectangulo(base,altura);
		System.out.println("Ingresa un lado: ");
		int lado = sc.nextInt();
		Rectangulo dos = new Rectangulo(lado);
		
		System.out.println("Area rec. uno. " + uno.area());
		System.out.println("Perimetro tec. uno. " + uno.perimetro());
		
		System.out.println("Area rec. dos. " + dos.area());
		System.out.println("Perimetro tec. dos. " + dos.perimetro());
		
		if (uno.EsMasAncho(dos)) {
			System.out.println("El uno es mas ancho.");
		} else {
			System.out.println("El dos es mas ancho");
		}
		if (uno.EsMasAlto(dos)) {
			System.out.println("El uno es mas alto");
		} else {
			System.out.println("El dos es mas alto");
		}
	}

}
