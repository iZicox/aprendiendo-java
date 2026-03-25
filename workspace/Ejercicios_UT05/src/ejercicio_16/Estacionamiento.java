package ejercicio_16;

import java.time.*;
import java.util.*;

public class Estacionamiento {
	private int numPlazas;
	private int capacidadRampa;
	private int precioSegundo;
	private int tiempoCortesia;
	private Map<String,LocalDateTime> estacionados;
	private Queue<String> colaEspera;
	
	
	public Estacionamiento(
			int plazas, 
			int capacidadRampa, 
			int precioSegundo, 
			int tiempoCortesia) {
		
		super();
		
		this.numPlazas = plazas;
		this.capacidadRampa = capacidadRampa;
		this.precioSegundo = precioSegundo;
		this.tiempoCortesia = tiempoCortesia;
		this.estacionados = new HashMap<String, LocalDateTime>();
		this.colaEspera = new LinkedList<String>();
	}
	
	public ResultadoEstacionamiento ResultadoEstacionar(String matricula) throws IllegalAccessException {
		// si ya esta estacionado
		if(this.estacionados.containsKey(matricula)) {
			throw new IllegalAccessException(
				"El vehiculo con la matricula " + matricula + " ya esta estacionado.");
		}
		// si hay plazas libre 
		if(this.estacionados.size() < this.numPlazas) {
			this.estacionados.put(matricula, LocalDateTime.now());
			return ResultadoEstacionamiento.Estacionado;
		}
		// si no hay plazas libres revisar si hay espacio en la cola (rampa)
		if(this.capacidadRampa > this.colaEspera.size()) {
			this.colaEspera.offer(matricula);
			return ResultadoEstacionamiento.Esperando;
		}else {
			return ResultadoEstacionamiento.Rechazado;
		}
	}
	
	public double retirarVehiculo(String matricula) {
		if(	!this.estacionados.containsKey(matricula) && 
			!this.colaEspera.contains(matricula)	) {
			throw new IllegalArgumentException(
					"La matricula " + matricula + " no esta en el estacionamiento."); 
		}
		if(	!this.estacionados.containsKey(matricula) &&
			this.colaEspera.contains(matricula)) {
			throw new IllegalStateException(
					"No se puede retirar el vehiculo con matricula " + matricula + 
					" proque esta en la cola de espera.");
		}
		
		int duracion = (int) Duration.between(this.estacionados.get(matricula), LocalDateTime.now()).toSeconds();
		
		
		if(this.tiempoCortesia >= duracion) {
			return 0;
		} else {
			this.estacionados.remove(matricula);
			if(!this.colaEspera.isEmpty()) { // si la cola no esta vacia agrega el proximo
				this.estacionados.put(this.colaEspera.poll(), LocalDateTime.now());
			}
			return (duracion * this.precioSegundo) / 100;
		}
		
	}
	
	public boolean hayPlazasLibres() {
		return this.estacionados.size() < this.numPlazas;
	}
	
	public boolean estaEstacionado(String matricula) {
		return this.estacionados.containsKey(matricula);
	}
	
	public boolean estaEsperando(String matricula) {
		return this.colaEspera.contains(matricula);
	}
	
	public boolean estaEstacionadopOEsperando(String matricula) {
		return this.estacionados.containsKey(matricula) || this.colaEspera.contains(matricula);
	}
	
	public Collection<String> getMatriculasEstaciondas(){
		List<String> copia = new LinkedList<String>(this.estacionados.keySet());
		Collections.sort(copia);
		return copia;
	}
	
	public Collection<String> getMatriculasEsperando(){
		List<String> copia = new LinkedList<String>(this.colaEspera);
		Collections.sort(copia);
		return copia;
	}
	
	public Collection<String> getMatriculasEsperandoOEstacionadas(){
		List<String> copia = new LinkedList<String>();
		copia.addAll(getMatriculasEsperando());
		copia.addAll(getMatriculasEstaciondas());
		Collections.sort(copia);
		return copia;
	}
	
	
	
	
	
}
