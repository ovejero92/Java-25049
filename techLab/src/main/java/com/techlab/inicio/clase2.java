package com.techlab.inicio;
import java.util.Scanner;

public class clase2 {
    public static void main(String[] args) {
        /*
        // nuemeros enteros 32 bits  -2,147,483,648 a 2,147,483,647.
        int saldo = 2147483612;
        // numero entero 64 bits -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807.
        long saldo2 = 21474832312L;
        // numero entero 8 bits -128 a 127
        byte edad = 23;
        // numeros decimales
        // 32 bits
        float dinero = 123.3f;
        // 64 bits
        double masDinero = 1233.41312;

        // booleanos
        boolean tieneDinero = true;
        boolean hayDescuentos = false;

        char arroba = '@';

        String nombre = "Gustavo";

        System.out.println(nombre.toUpperCase());

        Scanner entrada = new Scanner(System.in);

        int nuemro = entrada.nextInt();*/

        int edad = 18;
        String nombre = "Gustav";
        if( edad >= 18 && nombre.toUpperCase() == "GUSTAVO" ){
            System.out.println("Gustavo sos mayor");
        }  else {
            System.out.println("sos menor");
        }

        int i = 2;

        i = i + 2;

        System.out.println(contador++);


    }
}
