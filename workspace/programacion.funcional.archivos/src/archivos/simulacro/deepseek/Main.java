package archivos.simulacro.deepseek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static final String HOME = System.getProperty("user.home");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//ejercicio01();
			ejercicio02();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ejercicio03() {
		
	}
	
	public static void ejercicio02() throws IOException {
		File entrada = new File(HOME, "heroes.csv");
		File salida = new File(HOME, "heroes_nivel_alto.txt");
		List<String> lineas = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(entrada));
				BufferedWriter bw = new BufferedWriter(new FileWriter(salida))){
			String linea;
			while((linea = br.readLine()) != null) {
				String[] lineaArr = linea.split(",");
				if(Integer.parseInt(lineaArr[1]) >= 10 && lineaArr.length == 3) {
					bw.write(lineaArr[0] + " " + lineaArr[1] + " " + lineaArr[2] + "\n");
				}
			}
			
			
		}
	}
	
	public static void ejercicio01() throws FileNotFoundException, IOException {
		File entrada = new File(HOME, "eventos_raw.txt");
		File salida = new File(HOME, "eventos_limpios.txt");
		String contenidoProcesado = "";
		
		if(!entrada.exists()) {
			System.out.println("Archivo crudo no existe");
			return;
		}
		
		if(salida.exists()) {
			System.out.println("El archivo con datos procesados ya existe");
			return;
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(entrada));
				BufferedWriter bw = new BufferedWriter(new FileWriter(salida))){
			String linea;
			int cont = 0;
			while((linea = br.readLine()) != null) {
				cont++;
				if(!linea.isEmpty()) {
					contenidoProcesado += linea + "\n";
				}
			}
			System.out.println("lineas procesadas: " + cont);
			bw.write(contenidoProcesado);
		}
	}

}
