package com.techlab.inicio.utils;

public class ProductoUtils {
    public static String formatearNombreProducto(String nombre) {
        nombre = nombre.trim().toLowerCase(); // Paso 1
        String[] palabras = nombre.split(" "); // Paso 2
        StringBuilder sb = new StringBuilder(); // Paso 3

        for (String palabra : palabras) { // Paso 4
            if (!palabra.isEmpty()) {
                sb.append(Character.toUpperCase(palabra.charAt(0))) // Letra inicial en mayúscula
                        .append(palabra.substring(1)) // El resto en minúscula
                        .append(" "); // Agrega espacio entre palabras
            }
        }
        return sb.toString().trim(); // Quita el último espacio y retorna
    }

    public static int generarNumeroEnteroAleatorio(int minimo, int maximo) {
        return (int)Math.floor(Math.random() * (minimo -(maximo+1))+(maximo+1));
    }

    public static void main(String[] args) {
        String nombreFormateado = formatearNombreProducto("cafe starbucks");
        System.out.println("Producto formateado: " + nombreFormateado);
    }
}
