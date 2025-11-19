package Ejercicio_05;

public class Perro {
	public static final String SENTADO="Sentado";
	public static final String DE_PIE="De pie";
	public static final String TUMBADO="Tumbado";
	
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
	public void sentar() {
		if(getPosicion().equals(SENTADO)) {
			System.out.println("Ya estoy sentado.");
		} else {
			this.posicion=SENTADO;
		}
		
	}
	
	public void ponerseDePie() {
		if(getPosicion().equals(SENTADO)) {
			this.posicion=DE_PIE;
		} else if (getPosicion().equals(DE_PIE)){
			System.out.println("Ya esto de pie.");
		} else {
			System.out.printf("“Soy %s y no puedo ponerme de pie porque estoy tumbado%n",getNombre());
		}
	}
	
	public void tumbarse() {
		if(getPosicion().equals(SENTADO)) {
			this.posicion=TUMBADO;
		} else if (getPosicion().equals(TUMBADO)){
			System.out.println("Ya estoy tumbado");
		} else {
			System.out.printf("“Soy %s y no puedo tumbarme porque estoy de pie%n",getNombre());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
