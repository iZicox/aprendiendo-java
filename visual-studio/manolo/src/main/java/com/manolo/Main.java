package com.manolo;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String HOME = System.getProperty("user.home");

    public static void main(String[] args) {

        try {

            verificarArchivoUsuarios();



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * si el archivo no existe crea uno con un administrador
     * @throws IOException
     */
    public static void verificarArchivoUsuarios() throws IOException {
        File usuarios = new File(HOME, "manolo" + File.separator + "usuarios.bin");
        if (!usuarios.exists()) {
            System.out.println("Registro de primer administrador.");
            String nombre = Utilidades.leerCadena("Escribe un nombre: ");
            String password = Utilidades.leerCadena("Escribir contraseña: ");
            if (!usuarios.createNewFile()) {
                System.out.println("Error al crear archivo");
            }
            try (BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(usuarios, true))) {
                bw.write("administador,"+nombre + "," + password);
                bw.newLine();
            }
        }
    }

}