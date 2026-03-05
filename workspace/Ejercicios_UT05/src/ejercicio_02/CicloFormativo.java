package ejercicio_02;

public enum CicloFormativo {
	INFORMATICA, ADMINISTRACION, LOGISTICA, MARKETING;
	
	public static void main(String[] args) {
		CicloFormativo a = null;
		String b = "ADMINISTRACION";
		System.out.println(a instanceof CicloFormativo );
	}
}
