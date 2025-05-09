package com.techlab.inicio.after;

public class TablaDeMultiplicar {
        public static void main(String[] args) {
            int[][] tabla = new int[10][10];

            // Llenamos la tabla de multiplicar
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    tabla[i][j] = (i + 1) * (j + 1);
                }
            }

            // Encabezado de columnas
            System.out.print("     ");
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", j);
            }
            System.out.println();
            System.out.println("    -----------------------------------------");

            // Filas con encabezado y valores
            for (int i = 0; i < 10; i++) {
                System.out.printf("%2d |", i + 1);
                for (int j = 0; j < 10; j++) {
                    System.out.printf("%4d", tabla[i][j]);
                }
                System.out.println();
            }
        }
    }

