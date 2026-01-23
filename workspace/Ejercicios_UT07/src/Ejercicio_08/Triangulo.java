package Ejercicio_08;

public class Triangulo extends Figura {
	
	private double ladoA;
	private double ladoB;
	private double ladoC;

	
	
	public Triangulo(double ladoA, double ladoB, double ladoC) {
		super();
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
		double semiPerimetro = (perimetro()/2);
		return 0;
	}

}
