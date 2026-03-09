package cine;

public class SalaNormal extends Sala {
	private int aforo;
	private int entradasVendidas;
	private int entradasDisponibles;

	public SalaNormal(Pelicula pelicula, int aforo) {
		super(pelicula);
		this.aforo = aforo;
		this.entradasDisponibles = aforo;
		this.entradasVendidas = 0;
	}

	
	
	@Override
	public void venderEntrada(int entradas) {
		if(entradas < 0) {
			throw new NumberFormatException("Debes ingresar un numero de entradas mayor a cero.");
		}
		
		if(entradas > aforo) {
			throw new NumberFormatException("Las entradas superan el aforo.");
		}
		
		if(entradas > entradasDisponibles) {
			throw new NumberFormatException("Las entradas superan las que hay disponibles.");
		}
		

		
	}



	public int getAforo() {
		return aforo;
	}

	public int getEntradasVendidas() {
		return entradasVendidas;
	}

	public int getEntradasDisponibles() {
		return entradasDisponibles;
	}
	
	
	

	
}
