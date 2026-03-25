package Ejercicio_20;

public class Triangulo extends Figura {
	
	private double ladoA;
	private double ladoB;
	private double ladoC;

	
	
	public Triangulo(double ladoA, double ladoB, double ladoC) {
		super();
		
		if (ladoA + ladoB <= ladoC ||
		    ladoA + ladoC <= ladoB ||
		    ladoB + ladoC <= ladoA) {
			
			throw new IllegalArgumentException("Los lados no forman un triángulo válido");
		}

		
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	@Override
	public double perimetro() {
		
		return this.ladoA+this.ladoB+this.ladoC;
	}

	@Override
	public double area() {
		double s = (perimetro()/2);
		return Math.sqrt(s*(s-this.ladoA)*(s-this.ladoB)*(s-this.ladoC));
	}

}
