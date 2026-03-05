	package ejercicio_3;

import java.util.ArrayList;

import ejercicio_02.Alumno;

public class CuentaBancaria {
	
	private static int cuentaInicial = 1000000;
	
	private int numeroCuenta;
	private Cliente cliente;
	private ArrayList<Movimiento> movimientos = new ArrayList<>();
	
	public CuentaBancaria(Cliente cliente, int saldoInicial) {
		this.numeroCuenta = cuentaInicial;
		cuentaInicial++;
		this.cliente = new Cliente(cliente);
		Movimiento movimiento = new Movimiento(TipoMovimiento.INGRESO, saldoInicial, 0, "Apertura de cuenta");
		this.movimientos.add(movimiento);
		
	}
	
	public CuentaBancaria(Cliente cliente) {
		this.numeroCuenta = cuentaInicial;
		cuentaInicial++;
		this.cliente = new Cliente(cliente);
	}
	
	/**
	 * GetSaldo: recupera el saldo actual de la cuenta, obteniéndolo de la lista de
movimientos.
*/
	public double getSaldo() {
		return this.movimientos.get(this.movimientos.size()).getSaldoFinal();
	}
	/*
o Ingresar: recibe el importe y el concepto y realiza el ingreso en la cuenta.
	*/
	public void ingresar(double importe, String concepto) {
		Movimiento ingreso = new Movimiento(
										TipoMovimiento.INGRESO, 
										this.getSaldo(), 
										importe, 
										concepto);
		this.movimientos.add(ingreso);
	}
	/*
o Reembolsar: recibe la cantidad a reembolsar y realiza el reembolso. El
concepto en reembolsos se queda en blanco.
o Transferir: recibe el importe de la transferencia, el concepto, y realiza el
movimiento.
o RecibirTransferencia: recibe el importe de la transferencia, el concepto, y
realiza el movimiento.
o GetMovimientos: devuelve todos los movimientos de la cuenta, en orden de
fecha descendente, y realizando copia defensiva, para evitar alterar los
movimientos desde fuera de la cuenta.
	 */
	
}
