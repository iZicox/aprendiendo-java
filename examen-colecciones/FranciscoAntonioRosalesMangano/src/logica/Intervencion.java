package logica;

import java.time.LocalDate;

public class Intervencion {
	private TipoIntervencion tipoIntervencion;
	private LocalDate fechaEntrada;
	private int horasManoObra;
	private double costePiezas;
	
	public Intervencion(
			TipoIntervencion intervencion, 
			 int horasManoObra, double costePiezas) {
		super();
		this.tipoIntervencion = tipoIntervencion;
		this.fechaEntrada = LocalDate.now();
		this.horasManoObra = horasManoObra;
		this.costePiezas = costePiezas;
	}
	
	public Intervencion(Intervencion i) {
		this(
				i.getTipoIntervencion(),
				i.getHorasManoObra(),
				i.getCostePiezas());
	}

	public TipoIntervencion getTipoIntervencion() {
		return tipoIntervencion;
	}



	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}



	public int getHorasManoObra() {
		return horasManoObra;
	}



	public double getCostePiezas() {
		return costePiezas;
	}



	@Override
	public String toString() {
		return tipoIntervencion + ". Fecha Entrada: " + fechaEntrada + ". Horas Mano de Obra: " + horasManoObra + ". Coste Piezas: " + costePiezas + ".";
	}
	
	
	
	
}
