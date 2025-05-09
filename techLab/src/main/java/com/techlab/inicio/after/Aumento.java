package com.techlab.inicio.after;

public class Aumento {
    public static void main(String[] args) {
        double acumulado;
        double interes = 0.10;

        double[][] saldo = new double[6][5];

        // Cálculo de saldos con interés compuesto
        for (int i = 0; i < saldo.length; i++) {
            saldo[i][0] = 10000;
            acumulado = 10000;

            for (int j = 1; j < saldo[i].length; j++) {
                acumulado += acumulado * interes;
                saldo[i][j] = acumulado;
            }

            interes += 0.01; // Incrementa la tasa de interés por fila
        }

        // Encabezado de tasas de interés
        System.out.println("Años ->     1         2         3         4         5");
        System.out.println("------------------------------------------------------");

        interes = 0.10;
        // Mostrar los datos
        for (int i = 0; i < saldo.length; i++) {
            System.out.printf("Interés %.0f%%: ", interes * 100);
            for (int j = 0; j < saldo[i].length; j++) {
                System.out.printf("%9.2f ", saldo[i][j]);
            }
            System.out.println();
            interes += 0.01;
        }
    }
}
