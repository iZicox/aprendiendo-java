package ejercicio_17;

import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Paci	ente p1 = new Paciente("12345", "juan", Especialidad.GENERAL, "fiebre", Gravedad.ALTA, LocalDateTime.now());
		Paciente p1 = new Paciente("12345", "juan", Especialidad.GENERAL, "nose", Gravedad.BAJA, LocalDateTime.now());
		Paciente p2 = new Paciente("12345", "juan", Especialidad.GENERAL, "nose", Gravedad.BAJA, LocalDateTime.now());
		
		System.out.println(p1.equals("12345"));

	}

}
