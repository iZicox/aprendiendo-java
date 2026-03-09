package cine;

public abstract class Sala {
	private static int proxSala = 1;
	private int numSala;
	private Pelicula pelicula;
	
	
	public Sala(Pelicula pelicula) {
		this.numSala = proxSala;
		proxSala++;
		setPelicula(pelicula);
	}
	
	public abstract void venderEntrada( int entradas);
	
	public void setPelicula(Pelicula pelicula) {
		if(pelicula == null) {
			throw new NullPointerException("Pelicula invalida");
		}
		this.pelicula = new Pelicula(pelicula);
	}
	
	public Pelicula getPelicula() {
		return new Pelicula(this.pelicula);
	}
	
	public int getNumSala() {
		return numSala;
	}
	
	@Override
	public String toString() {
		return "Sala numero " + numSala + "\t" + pelicula.toString();
	}


}
