package logica;

public class OrdenTrabajo {
	private Vehiculo vehiculo;
	private Intervencion intervencion;
	
	public OrdenTrabajo(Vehiculo vehiculo, Intervencion intervencion) {
		super();
		this.vehiculo = vehiculo;
		this.intervencion = intervencion;
	}
	

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Intervencion getIntervencion() {
		Intervencion copia = new Intervencion(intervencion);
		return copia;
	}
	
	
	
}
