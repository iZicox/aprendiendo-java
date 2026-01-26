package Ejercicio_08;

public abstract class Paralelogramo extends Figura {
	
	private double base;
	private double altura;
	public Paralelogramo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}
	protected double getBase() {
		return base;
	}
	@Override
	public double perimetro() {
		
		return (this.base + this.altura) * 2;
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.base * this.altura;
	}
	
	
	
}
	
	
	
	
	


