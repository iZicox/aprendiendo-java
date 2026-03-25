package Ejercicio_20;

public class Romboide extends Paralelogramo {
	private double ladoOblicuo;

	public Romboide(double base, double altura, double ladoOblicuo) {
		super(base, altura);
		this.ladoOblicuo = ladoOblicuo;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return (super.getBase() + this.ladoOblicuo) *2;
	}
	
	
}
