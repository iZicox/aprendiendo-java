package examen.archivos;

import java.io.*;
import java.util.*;

public class MainArchivos {

    private static final String RUTA_DATOS = "datos" + File.separator + "vehiculos.dat";
    private static final String RUTA_INFORME = "datos" + File.separator + "informe.txt";
    private static final String RUTA_BINARIO_SALIDA = "datos" + File.separator + "vehiculos_filtrados.dat";

    public static void main(String[] args) {
    	
    	try {
    		List<Vehiculo> listaVehiculos = leerFicheroBinario(RUTA_DATOS);

            // Si la lista es nula o está vacía (dependiendo de tu gestión), 
            // evitamos procesar el resto para evitar NullPointerException
            if (listaVehiculos != null && !listaVehiculos.isEmpty()) {
                generarInformeTexto(listaVehiculos);
                procesarYGuardarFiltrados(listaVehiculos);
                System.out.println("Proceso finalizado con éxito.");
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        
        
    }

    /**
     * Lee el archivo binario usando DataInputStream.
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public static List<Vehiculo> leerFicheroBinario(String ruta) throws FileNotFoundException, IOException {
        List<Vehiculo> lista = new ArrayList<>();
        // TODO: Implementar lectura del fichero binario
        File archivo = new File(ruta);
        //verificat que el archivo exista
        if(!archivo.exists()) {
        	// devolvemos una lista vacia
        	return lista;
        }
        
        // abrir el data input para enscribir en binario
        try(DataInputStream dis = new DataInputStream(new FileInputStream(archivo))){
        	// como dice que se escribieron 20 registros iniciamos con un bucle for de 20
        	for(int i = 0; i < 20 ; i++) {
        		// vamos tomando los datos de cada iteracion para guardarlo en la lista
        		String matricula = dis.readUTF();
        		String marca = dis.readUTF();
        		int anioMatriculacion = dis.readInt();
        		double cargaMax = dis.readDouble();
        		boolean enServicio = dis.readBoolean();
        		lista.add(new Vehiculo(matricula, marca, anioMatriculacion, cargaMax, enServicio));
        	}
        }
        return lista;
    }

    /**
     * Genera un informe de texto legible.
     * @throws IOException 
     */
    public static void generarInformeTexto(List<Vehiculo> lista) throws IOException {
        // TODO: Implementar escritura del informe en modo texto
    	// abrimos el writer legible para el humano
    	try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_INFORME,true))){
    		bw.write("INFORME DE VEHÍCULOS\n===========================================\n");
    		// luego de la cabecera escribimos la cantidad de resgistros que tenga la lista
    		for (Vehiculo vehiculo : lista) {
				bw.write(vehiculo.toString() + "\n");
			}
    		bw.write("===========================================\n");
    		// escribimos el resumen del total de registros procesados
    		bw.write("Total de vehículos procesados: " + lista.size() + "\n");
    	}
    }

    /**
     * Filtra vehículos en servicio, ordena y guarda.
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public static void procesarYGuardarFiltrados(List<Vehiculo> lista) throws FileNotFoundException, IOException {
        // TODO: 1. Filtrar
        // TODO: 2. Ordenar
        // TODO: 3. Escribir
    	File archivo =  new File(RUTA_BINARIO_SALIDA);
    	
    	// filtramos la lista de entrada segun los requerimientos
    	List<Vehiculo> procesado = lista.stream()
    										.filter(Vehiculo::isEnServicio)
    										.sorted((v1,v2) -> v1.compareTo(v2))
    										.toList();
    	
    	
    	try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo, true))){
    		dos.writeInt(procesado.size());
    		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo, false))){
    			oos.writeObject(procesado);
    		}
    	}
    }
}
