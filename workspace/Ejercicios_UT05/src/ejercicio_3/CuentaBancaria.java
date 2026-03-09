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
		Movimiento movimiento = new Movimiento(	
											TipoMovimiento.INGRESO, 
											0, 
											saldoInicial, 
											"Apertura de cuenta");
		this.movimientos.add(movimiento);
		
	}
	
	public CuentaBancaria(Cliente cliente) {
		this.numeroCuenta = cuentaInicial;
		cuentaInicial++;
		this.cliente = new Cliente(cliente);
		
		Movimiento movimiento = new Movimiento(	
				TipoMovimiento.INGRESO, 
				0, 
				0, 
				"Apertura de cuenta");
		this.movimientos.add(movimiento);
	}
	
	/**
	 * GetSaldo: recupera el saldo actual de la cuenta, obteniéndolo de la lista de
movimientos.
*/
	public double getSaldo() {
		return this.movimientos.get(this.movimientos.size()-1).getSaldoFinal();
	}
	/*
o Ingresar: recibe el importe y el concepto y realiza el ingreso en la cuenta.
	*/
	/**
	 * 
	 * @param importe debe ser positivo mayor a cero
	 * @param concepto
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
*/
	public void reembolsar(double cantidad) {
		Movimiento movimiento = new Movimiento(TipoMovimiento.REINTEGRO,this.getSaldo(),cantidad, "");
		this.movimientos.add(movimiento);
	}
	/*
o Transferir: recibe el importe de la transferencia, el concepto, y realiza el
movimiento.
*/
	public void transferir(double importe, String concepto, CuentaBancaria cuentaDestino) {
		Movimiento movimiento = new Movimiento(
											TipoMovimiento.TRANSFERENCIA_A_OTRAS_CUENTAS, 
											this.getSaldo(), 
											(importe*-1), 
											concepto);
		this.movimientos.add(movimiento);
		cuentaDestino.recibirTransferencia(importe, concepto);
		
	}
	/*
o RecibirTransferencia: recibe el importe de la transferencia, el concepto, y
realiza el movimiento.
*/
	private void recibirTransferencia(double importe, String concepto) {
		Movimiento movimiento = new Movimiento(
											TipoMovimiento.TRANSFERENCIA_A_FAVOR, 
											this.getSaldo(), 
											importe, 
											concepto);
		
		this.movimientos.add(movimiento);
	}
	/*
o GetMovimientos: devuelve todos los movimientos de la cuenta, en orden de
fecha descendente, y realizando copia defensiva, para evitar alterar los
movimientos desde fuera de la cuenta.
	 */
	public ArrayList<Movimiento> getMovimientos() {
		ArrayList<Movimiento> copia = new ArrayList<>(this.movimientos);
		//ArrayList<Movimiento> copia = (ArrayList<Movimiento>) this.movimientos.clone();
		return copia;
	}

	public static int getCuentaInicial() {
		return cuentaInicial;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	
	
	
	
}
