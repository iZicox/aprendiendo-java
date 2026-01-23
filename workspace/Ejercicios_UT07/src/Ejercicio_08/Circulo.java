package Ejercicio_08;

public class Circulo extends Figura {
	
	private double radio;
	
	Circulo(double radio){
		super();
		this.radio = radio;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 2* Math.PI * this.radio;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(this.radio, 2);
	}
	
	

}
