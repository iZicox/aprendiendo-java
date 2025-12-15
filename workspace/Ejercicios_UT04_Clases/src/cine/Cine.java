package cine;

public class Cine {
	private Butaca [][] sala;
	private Pelicula pelicula;
	private static int contadorPeliculas;
	
	public Cine(Pelicula pelicula, int fila, int col) throws NullPointerException, NumberFormatException {
		try {
			if(pelicula == null) {
				throw new NullPointerException("La pelicula no puede ser nula");
			}
			if(fila <= 0 || fila >= 16) {
				throw new NumberFormatException("Las filas deben estrar entre 1 y 15.");
			}
			if(col <= 0 || col >= 21) {
				throw new NumberFormatException("Las columnas deben estrar entre 1 y 20.");
			}
		}catch(NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		this.sala = new Butaca[fila][col];
		for(int i = 0; i < this.sala.length; i++) {
			for(int j = 0; j < this.sala[i].length; j++) {
				this.sala[i][j] = Butaca.LIBRE;
			}
		}
		this.pelicula = pelicula;
	}
	
	
	
	public Butaca[][] getSala() {
		return sala;
	}



	public Pelicula getPelicula() {
		return pelicula;
	}



	public static int getContadorPeliculas() {
		return contadorPeliculas;
	}
	
	
	public void cambiarPelicula(Pelicula pelicula) {
		try {
			if(pelicula == null) {
				throw new NullPointerException("La pelicula no puede ser nula");
			}
		}catch(NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		}
		for(int i = 0; i < this.sala.length; i++) {
			for(int j = 0; j < this.sala[i].length; j++) {
				this.sala[i][j] = Butaca.LIBRE;
			}
		}
		contadorPeliculas++;
		
	}
	
	public int contarButacas(int filaInicio, int colInicio) {
		try {
			if(filaInicio < 1 || filaInicio > this.sala.length) {
				throw new IndexOutOfBoundsException("Fila fuera del rango debe ser entre 1 y "+this.sala.length);
			}
			if(colInicio < 1 || colInicio > this.sala[0].length) {
				throw new IndexOutOfBoundsException("Butaca fuera del rango debe ser entre 1 y "+this.sala.length);
			}
			int cont = 0;
			for( int i = filaInicio-1; i < this.sala.length; i++ ) {
				for(int j = colInicio-1; j < this.sala[i].length; j++ ) {
					if(this.sala[i][j] == Butaca.LIBRE) {
						cont++;
					}
				}
			}
			return cont;
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Error: " + e.getMessage());
			return 0;
		}
		
	}

	public double venderEntrada(int cantidad, int filaInicio, int colInicio) {
		
		
		try {
			//validacion del indice
			if(filaInicio < 1 || filaInicio > this.sala.length) {
				throw new IndexOutOfBoundsException("Fila fuera del rango debe ser entre 1 y "+this.sala.length);
			}
			if(colInicio < 1 || colInicio > this.sala[0].length) {
				throw new IndexOutOfBoundsException("Butaca fuera del rango debe ser entre 1 y "+this.sala.length);
			}
			
			//validacion que no hallan ocupados en el rango
			for( int i = filaInicio-1; i < this.sala.length; i++ ) {
				for(int j = colInicio-1; j < this.sala[i].length; j++ ) {
					if(this.sala[i][j] == Butaca.OCUPADO) {
						throw new IllegalStateException("Hay butacas ocupadas que no se pueden comprar");
					}
				}
			}
			
			//programa
			int cont = 1;
			for( int i = filaInicio-1; i < this.sala.length && cont <= cantidad; i++ ) {
				for(int j = colInicio-1; j < this.sala[i].length && cont <= cantidad; j++ ) {
					if(this.sala[i][j] == Butaca.LIBRE) {
						this.sala[i][j] = Butaca.OCUPADO;
						cont++;
					}
				}
			}
			return this.pelicula.getPrecioEntrada() * (double)(cantidad);
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Error: " + e.getMessage());
			return 0;
		}catch(IllegalStateException e) {
			System.out.println("Error: " + e.getMessage());
			return 0;
		} 
	}
	
	public void verSala() {
		System.out.printf("----PANTALLA---- Pelicula: %s\n",this.pelicula.getTitulo());
		for(int i = 0; i < this.sala.length; i++) {
			System.out.printf("Fila %d: \t", (i+1));
			for(int j = 0; j < this.sala[i].length; j++) {
				if(this.sala[i][j] == Butaca.LIBRE) {
					System.out.printf("[L]");
				} else {
					System.out.printf("[O]");
				}
				
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		Pelicula scareface = new Pelicula("Scareface",120,10);
		Cine jj = new Cine(scareface,10,10);
		Pelicula aa = new Pelicula("MIB", 120, 10);
		for(int i = 0; i < jj.getSala().length; i++) {
			for(int j = 0; j < jj.getSala()[i].length; j++) {
				System.out.print(jj.getSala()[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(Cine.getContadorPeliculas());
		
		jj.cambiarPelicula(aa);
		
		System.out.println(Cine.getContadorPeliculas());
		
		System.out.println(jj.contarButacas(1, 7));
		
		System.out.println(jj.venderEntrada(2, 1, 5));
		System.out.println(jj.venderEntrada(2, 10, 8));
		
		for(int i = 0; i < jj.getSala().length; i++) {
			for(int j = 0; j < jj.getSala()[i].length; j++) {
				System.out.print(jj.getSala()[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(jj.contarButacas(10, 5));
		
		jj.verSala();
		
	}
}
