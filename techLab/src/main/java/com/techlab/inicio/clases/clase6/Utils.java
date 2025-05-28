package com.techlab.inicio.clases.clase6;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Utils {
   // separador
    public static String separadorDeMiles(double numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setGroupingSeparator('.');

        DecimalFormat formato = new DecimalFormat("#,##0.00",simbolo);

        return formato.format(numero);
    }
    // capitalize
    public static String capitalize(String nombre) {
        String nombreFormateado = nombre.trim().toLowerCase(); // convertir a minúsculas
        String[] palabras = nombreFormateado.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                sb.append(Character.toUpperCase(palabra.charAt(0)));
                if (palabra.length() > 1) {
                    sb.append(palabra.substring(1)); // ya está en minúscula
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
