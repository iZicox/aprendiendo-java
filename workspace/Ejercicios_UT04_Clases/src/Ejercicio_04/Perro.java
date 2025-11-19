package Ejercicio_04;

public class Perro {
	public static final String SENTADO="Sentado";
	public static final String DE_PIE="De pie";
	public static final String TUMPADO="Tumbado";
	
	private String nombre;
	private String raza;
	private String propietario;
	private int edad;
	private double peso;
	private String posicion;
	
	//constructor
	public Perro() {
		this.posicion=SENTADO;
	}
	public Perro(String nombre, String raza, String propietario, int edad, double peso) {
		this.nombre=nombre;
		this.raza=raza;
		this.propietario=propietario;
		this.edad=edad;
		this.peso=peso;
		this.posicion=SENTADO;
	}
	
	//getter y setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getPosicion() {
		return posicion;
	}
	
	//metodos
	public void comer(int cantidadComida) {
		if(cantidadComida<0){
			cantidadComida = 0;
			return;
		} else if (cantidadComida>200) {
			cantidadComida=200;
		}
		
		System.out.printf("Soy %s y estoy comiendo %d gr de comida.%n",this.nombre,cantidadComida);
		
		setPeso(this.peso+=(((double)cantidadComida/10)/1000));
	}
	
	public void jugar(int tiempo) {
		if(tiempo < 0) {
			tiempo=0;
			return;
		} else if (tiempo > 10) {
			tiempo=10;
		}
		
		System.out.printf("Soy %s y estoy jugando %d minutos.%n",this.nombre,tiempo);
		
		setPeso(this.peso-=(tiempo/7));
	}
}
