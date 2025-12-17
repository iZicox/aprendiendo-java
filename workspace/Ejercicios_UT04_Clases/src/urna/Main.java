package urna;

public class Main {
	private static final int capacidad = 10;
	private static final int SIM_TOTAL = 10;
	private static final int BOLAS_ROJAS = 3;
	private static final int BOLAS_VERDES = 2;
	private static final int BOLAS_AZULES = 5;
	private static final ColorBola[] SECUENCIA = {ColorBola.ROJO,ColorBola.AZUL,ColorBola.ROJO,ColorBola.AZUL};
	private static final boolean CON_REEMPLAZO = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Urna urna = new Urna(capacidad);
		
		int exito = 0;
		for(int numSim = 1; numSim < SIM_TOTAL; numSim++) {
			try {
				rellenarUrna(urna);
				if(esSimulacionCorrecta(urna)) {
					exito++;
				}
			}catch(IllegalStateException e) {
				System.out.println("error: " + e.getMessage());
				return;
			}
		}
	}
	
	private static void rellenarUrna(Urna urna) {
		urna.limpiar();
		for(int i = 0; i < BOLAS_ROJAS; i++) {
			urna.meterBola(new Bola(ColorBola.ROJO));
		}
		for(int i = 0; i < BOLAS_VERDES; i++) {
			urna.meterBola(new Bola(ColorBola.VERDE));
		}
		for(int i = 0; i < BOLAS_AZULES; i++) {
			urna.meterBola(new Bola(ColorBola.AZUL));
		}
	}
	
	public static boolean esSimulacionCorrecta(Urna urna) {
		for(int i = 0; i < SECUENCIA.length; i++) {
			Bola sacada = urna.sacarBola(CON_REEMPLAZO);
			if (sacada.getColor() != SECUENCIA[i]) {
				return false;
			}
		}
		return true;
	}

}
