package com.manolo;

import java.util.Scanner;

public class Utilidades {
    public static final Scanner IN = new Scanner(System.in);
    public static String leerCadena(String msj){
        System.out.print(msj);
        return IN.nextLine();
    }

    public static int leerEntero(String msj, int min, int max){
        while(true){
            System.out.print(msj);
            Integer num = Integer.parseInt(IN.nextLine());
            if(num >= min && num <= max){
                return num;
            }
        }

    }
}
