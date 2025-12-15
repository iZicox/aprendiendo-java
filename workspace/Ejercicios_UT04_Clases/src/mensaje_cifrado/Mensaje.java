package mensaje_cifrado;

public class Mensaje {
	private String contenido;
	private String remitente;
	
	public Mensaje(String mensaje, String autor, int codigo) {
		this.contenido = cifrar(mensaje, codigo);
		this.remitente = autor;
	}
	
	
	
	
	public String getContenido() {
		return contenido;
	}




	public String getRemitente() {
		return remitente;
	}




	private String cifrar(String mensaje, int codigo) {
		if(mensaje == null) {
			throw new NullPointerException(String.format("El mensaje no puede ser nulo."));
		}
		
		
		char[] mensajeOriginal = mensaje.toCharArray();
		char[] mensajeCifrado = new char[mensajeOriginal.length];
		
		for(int i = 0; i < mensajeCifrado.length; i++) {
			mensajeCifrado[i] = (char) (mensajeOriginal[i] + codigo + i);
		}
		
		StringBuilder resultado = new StringBuilder();
		
		for(int i = 0; i < mensajeCifrado.length; i++) {
			resultado.append(mensajeCifrado[i]);
		}
		return resultado.toString();
	}
	
	public String decifrar(int codigo) {
		String mensaje = this.contenido;
		char [] mensajeCifrado = mensaje.toCharArray();
		StringBuilder resultado = new StringBuilder();
		for(int i = 0; i < mensajeCifrado.length; i++) {
			resultado.append((char)(mensajeCifrado[i] - codigo - i));
		}
		
		return resultado.toString();
	}
	
	
}
