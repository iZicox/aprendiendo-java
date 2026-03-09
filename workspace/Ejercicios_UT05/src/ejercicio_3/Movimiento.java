package ejercicio_3;

import java.time.LocalDateTime;

public class Movimiento {
	private TipoMovimiento tipoMovimiento;
	private LocalDateTime fechaMovimiento;
	private double saldoInicial;
	private double importe;
	private double saldoFinal;
	private String concepto;
	
	public Movimiento(TipoMovimiento tipoMovimiento, double saldoInicial, double importe, String concepto) {
		super();
		this.tipoMovimiento = tipoMovimiento;
		if(tipoMovimiento.toString().equals("RETIRO") && importe > 0) {
			throw new IllegalArgumentException("El importe de un retiro debe ser negativo.");
		}
		if(tipoMovimiento.toString().equals("INGRESO") && importe < 0) {
			throw new IllegalArgumentException("El importe de un ingreso debe ser positivo.");
		}
		if(tipoMovimiento.toString().equals("TRANSFERENCIA_A_OTRAS_CUENTAS") && importe > 0) {
			throw new IllegalArgumentException(
					"El importe de una transferencia a otras cuentas debe ser negativo.");
		}
		if(tipoMovimiento.toString().equals("TRANSFERENCIA_A_FAVOR") && importe < 0) {
			throw new IllegalArgumentException(
					"El importe de una transferencia a favor debe ser positivo.");
		}
		this.saldoInicial = saldoInicial;
		this.importe = importe;
		this.concepto = concepto;
		this.fechaMovimiento = LocalDateTime.now();
		this.saldoFinal = saldoInicial + importe;
	}
	
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	public LocalDateTime getFechaMovimiento() {
		return fechaMovimiento;
	}
	public double getSaldoInicial() {
		return saldoInicial;
	}
	public double getImporte() {
		return importe;
	}
	public double getSaldoFinal() {
		return saldoFinal;
	}
	public String getConcepto() {
		return concepto;
	}

	@Override
	public String toString() {
		return this.fechaMovimiento + " - " + this.tipoMovimiento.toString() + " - Saldo incial: " + this.saldoInicial + " - Importe: " + this.importe + " - Saldo final: " + this.saldoFinal + ".";
	}
	
	
	
	
	
	
	
}
