package biblioteca;

import java.util.ArrayList;

public class Revista extends FondoBibliografico {
	private int numEjemplar;
	private Frecuencia frecuencia;
	
	
	
	/**
	 * 
	 * @param isbn
	 * @param titulo
	 * @param autores
	 * @param anioPublicacion
	 * @param categoria
	 * @param numEjemplar
	 * @param frecuencia
	 */
	public Revista(String isbn, String titulo, ArrayList<String> autores, int anioPublicacion, Categoria categoria,
			int numEjemplar, Frecuencia frecuencia) {
		super(isbn, titulo, autores, anioPublicacion, categoria);
		this.numEjemplar = numEjemplar;
		this.frecuencia = frecuencia;
	}
	
	public Revista(Revista revista) {
		this(
				revista.getIsbn(),
				revista.getTitulo(),
				revista.getAutores(),
				revista.getAnioPublicacion(),
				revista.getCategoria(),
				revista.getNumEjemplar(),
				revista.getFrecuencia());
	}




	public int getNumEjemplar() {
		return numEjemplar;
	}

	public Frecuencia getFrecuencia() {
		return frecuencia;
	}

	@Override
	public String getResumen() {
		// TODO Auto-generated method stub
		return "Resumen de la revista";
	}

}
