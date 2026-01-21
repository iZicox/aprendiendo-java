package Ejercicio_05;

import java.time.LocalDate;

public class ProductoRefrigerado extends Producto {
	private int codigoOrganismoSupervisor;

	public ProductoRefrigerado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoRefrigerado(LocalDate caducidad, int lote, int codigoOrganismoSupervisor) throws IllegalStateException {
		super(caducidad, lote);
		// TODO Auto-generated constructor stub
		
		if(codigoOrganismoSupervisor <= 0) {
			throw new IllegalStateException("El valor no puede ser igual o menor a cero.");
		}
		
		this.codigoOrganismoSupervisor = codigoOrganismoSupervisor;
		
	}

	public int getCodigoOrganismoSupervisor() {
		return codigoOrganismoSupervisor;
	}

	public void setCodigoOrganismoSupervisor(int codigoOrganismoSupervisor) {
		this.codigoOrganismoSupervisor = codigoOrganismoSupervisor;
	}

	@Override
	public String toString() {
		return super.toString() + "Cod. Org. Supervisor: " + codigoOrganismoSupervisor + ". ";
	}
	
	
	
	
	
	

}
