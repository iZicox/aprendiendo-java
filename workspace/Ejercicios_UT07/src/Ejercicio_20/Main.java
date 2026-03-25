package Ejercicio_20;

import java.util.Random;

public class Main {
	
	private static final int LADO_MIN = 0;
	private static final int LADO_MAX = 10;
	private static final int NUM_FIG = 5;

	public static void main(String[] args) {
		
		Cuadrado c = new Cuadrado(10);
		System.out.println(c.perimetro());
		c.escalar(0.2);
		System.out.println(c.perimetro());

		/*
		
		System.out.println("llenando array con " + NUM_FIG + " figuras.");
		Figura fig [] = new Figura[NUM_FIG];
		for(int i = 0; i < fig.length; i++) {
			fig[i] = figuraAleatoria();
		}
		System.out.println("Las figuras creadas fueron:");
		mostrarFiguras(fig);/**/
	}
	
	private static int aleatorioInt(int min, int max) {
		return new Random().nextInt(min,max+1);
	}
	
	private static double ladoAleatorio(int min, int max) {
		return new Random().nextDouble(min,max+0.1);
	}
	
	private static Figura figuraAleatoria() {
		Figura fig = null;
		int opcion = aleatorioInt(1, 5);
		switch(opcion) {
			case 1:
				fig = new Circulo(ladoAleatorio(LADO_MIN,LADO_MAX));
				break;
			case 2:
				while(true) {
					try {
						fig = new Triangulo(ladoAleatorio(LADO_MIN,LADO_MAX), ladoAleatorio(LADO_MIN,LADO_MAX), ladoAleatorio(LADO_MIN,LADO_MAX));
						break;
						
					}catch(Exception e) {
						
					}
					
				}
			case 3:
				fig = new Cuadrado(ladoAleatorio(LADO_MIN,LADO_MAX));
				break;
			case 4:
				fig = new Rectangulo(ladoAleatorio(LADO_MIN,LADO_MAX), ladoAleatorio(LADO_MIN,LADO_MAX));
				break;
			case 5:
				fig = new Romboide(ladoAleatorio(LADO_MIN,LADO_MAX),ladoAleatorio(LADO_MIN,LADO_MAX),ladoAleatorio(LADO_MIN,LADO_MAX));
				break;
			default:
				System.out.println("Valor invalido.");
				break;	
		}
		return fig;
	}
	
	private static String tipoFigura(Figura fig) {
		
		
			if (fig instanceof Circulo) {
		        return "Círculo";
		    } else if (fig instanceof Cuadrado) {
		        return "Cuadrado";
		    } else if (fig instanceof Rectangulo) {
		        return "Rectángulo";
		    } else if (fig instanceof Romboide) {
		        return "Romboide";
		    } else if (fig instanceof Triangulo) {
		        return "Triángulo";
		    }

	
		return "Figura desconocida";
	}
	
	private static void mostrarFiguras(Figura fig []) {
		for (Figura figura: fig){
			System.out.println("==============");
			System.out.println("Esta figura es un: " + tipoFigura(figura));
			System.out.println("Su area es de: " + String.format("%.2f",figura.area()));
			System.out.println("Su perimetro es de: " + String.format("%.2f", figura.perimetro()));
		}
	}
}
