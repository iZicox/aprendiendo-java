package programacion.funcionaleje.ejercicio_01;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String home = System.getProperty("user.home");
		File slash = new File(File.separator);
		File carpeta = new File(home + slash + "nueva" + slash + "otra");
		System.out.println(carpeta.toString());
		
		if(carpeta.exists())
		{
			System.out.println("La carpeta existe, no se puede crear");
		} else 
		{
			System.out.println("Creando carpeta");
			if(!carpeta.mkdirs()) 
			{
				System.out.println("Error al crear carpeta");
				return;
			}
			System.out.println(carpeta.getParentFile());
			carpeta.delete();
		}


	}

}
