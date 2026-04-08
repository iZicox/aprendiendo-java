package pruebas;

import java.io.File;
import java.io.IOException;

public class Ejercicio_01 {

	public static void main(String[] args) {
		
		File f = new File("./hola.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
