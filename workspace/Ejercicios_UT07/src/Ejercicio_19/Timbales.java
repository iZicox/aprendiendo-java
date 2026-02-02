package Ejercicio_19;

public class Timbales extends Percusion implements Afinable {

	public Timbales(String propietario) {
		super(propietario, 6);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es un timbales.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es un timbales.");
	}

	@Override
	public void afinar() {
		System.out.println("Afinando timbales");
		
	}
	
}
