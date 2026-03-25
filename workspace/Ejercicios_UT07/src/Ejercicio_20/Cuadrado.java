package Ejercicio_20;

public class Cuadrado extends Paralelogramo {
	

	public Cuadrado(double lado) {
		super(lado, lado);
		
	}

	@Override
	public void escalar(double factor) {
		super.setAltura(super.getBase()*factor);
		super.setBase(super.getBase()*factor);
		
	}

	
}
