package encriptacion;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main {
	
	public static final String LLAVE = "OfQa3JcI3t53m2r3SGM/pqiOFMiAROYB1sNv2d7pWK8=";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean flagMenu = false;
		boolean flagSwitch = false;
		int opcion=0;
		
		while(!flagSwitch) {
			while(!flagMenu) {
				System.out.println("******PROGRAMA DE ENCRIPTACION******");
				System.out.println("1. Encriptar.");
				System.out.println("2. Desencriptar.");
				System.out.println("0. Salir.");
				System.out.print("Ingresa una opcion: ");
				opcion = sc.nextInt();
				if (opcion < 0 || opcion > 2) {
					
					System.err.println("Opcion equivocada.");
				} else {
					flagMenu = true;
				}
			}
			
			switch(opcion) {
				case 1:
					System.out.println("***********Encriptando mensaje***********");
					System.out.print("Escribe tu mensaje: ");
					String mensajeE = sc.next();
					String mensajeEncriptadoE = encriptar(mensajeE);
					System.out.println("Tu mensaje encriptado es: " + mensajeEncriptadoE);
					break;
				case 2:
					System.out.println("***********Desencriptando mensaje***********");
					System.out.print("Escribe tu mensaje encriptado: ");
					String mensajeEncriptadoD = sc.next();
					String mensajeDesencriptadoD = desencriptar(mensajeEncriptadoD);
					System.out.println("Tu mensaje desencriptado es: " + mensajeDesencriptadoD);
					break;
				case 0:
					System.out.println("*******Cerrando sesion******");
					flagSwitch = true;
					break;
			}
			
			flagMenu = false;
		
		}
		
			
		
	}
	
	// clave de encriptacion y desencriptacion
	public static SecretKeySpec crearClave(String llave) {
		try {
			// convertir la cadena a bytes con soporte utf-8
			byte[] cadena = llave.getBytes("UTF-8");
			
			// crear instancia del algoritmo para el hash
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			
			//calcular el hash con el array de bytes de la cadena
			cadena = md.digest(cadena);
			
			cadena = Arrays.copyOf(cadena, 16);
			
			SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
			
			return secretKeySpec;
		}catch (Exception e) {
			return null;
		}
		
	}
	
	//encriptar
	public static String encriptar(String encriptar) {
		try {
			// crea la clave secreta con el metodo anterior
			//usando la llave declarada como constante
			SecretKeySpec secretKeySpec = crearClave(LLAVE);
			
			//creamos una instancia de la clase Cipher
			//cipher es la clase que hace la encriptacion/desencriptacion
			//en este caso con el algoritmo AES
			Cipher cipher = Cipher.getInstance("AES");
			
			//activamos en modo encriptacion de cipher 
			//con la clave secreta que creamos anteriormente
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			
			//convertimos la cadena a encriptar en un array con UTF-8
			byte[] cadena = encriptar.getBytes("UTF-8");
			
			//encriptamos el array anterior con el formato AES gracias a la instancia
			//que creamos de cipher devolviendo los byte encriptados
			byte[] encriptada = cipher.doFinal(cadena);
			
			//codificamos los bytes a Base64 para que sean legibles y poderlos 
			//procesar y enviar en el return
			//usamos getEncoder y encodeToString
			String cadenaEncriptada = Base64.getEncoder().encodeToString(encriptada);

			return cadenaEncriptada;
			
		}catch(Exception e) {
			return "";
		}
	}
	
	//desencriptar
	public static String desencriptar(String desencriptar) {
		try {
			// crea la clave secreta con el metodo anterior
			//usando la llave declarada como constante
			SecretKeySpec secretKeySpec = crearClave(LLAVE);
			
			//creamos una instancia de la clase Cipher
			//cipher es la clase que hace la encriptacion/desencriptacion
			//en este caso con el algoritmo AES
			Cipher cipher = Cipher.getInstance("AES");
			
			//activamos en modo desencriptacion de cipher 
			//con la clave secreta que creamos anteriormente
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			
			//convertimos la cadena a encriptar en un array con UTF-8
			//usamos getDecode y decode ademas que lo guardamos en un array de bytes
			byte[] cadena = Base64.getDecoder().decode(desencriptar);
			
			//desencriptamos el array anterior
			byte[] desencriptada = cipher.doFinal(cadena);
			
			//codificamos los bytes a Base64 para que sean legibles y poderlos 
			//procesar y enviar en el return
			String cadenaDesencriptada = new String(desencriptada);

			return cadenaDesencriptada;
			
		}catch(Exception e) {
			return "";
		}
	}
	

}
