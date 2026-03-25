package ejercicio_17_02;

import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		PriorityQueue<Paciente> cola = new PriorityQueue<>();

        // Creamos algunos pacientes de prueba
        Paciente p1 = new Paciente("111A", Especialidad.GENERAL, Gravedad.MEDIA, "Dolor en el pecho");
        esperar(1000); // Para diferenciar la hora de llegada
        Paciente p2 = new Paciente("222B", Especialidad.GENERAL, Gravedad.ALTA, "Fractura abierta");
        esperar(1000);
        Paciente p3 = new Paciente("333C", Especialidad.GENERAL, Gravedad.BAJA, "Dolor de cabeza");
        esperar(1000);
        Paciente p4 = new Paciente("444D", Especialidad.GENERAL, Gravedad.ALTA, "Arritmia");

        // Añadimos a la cola
        cola.add(p1);
        cola.add(p2);
        cola.add(p3);
        cola.add(p4);

        System.out.println("Pacientes en orden de prioridad:\n");

        // Extraemos en orden de prioridad
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }

    // Método auxiliar para espaciar las fechas de llegada
    private static void esperar(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
