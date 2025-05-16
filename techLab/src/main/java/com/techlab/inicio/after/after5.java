package com.techlab.inicio.after;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class after5 {
    public static void main(String[] args) {
        int numero = 1231335;

        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setGroupingSeparator('.');

        DecimalFormat formato = new DecimalFormat("#,###",simbolo);

        String numeroFormateado = formato.format(numero);

        System.out.println(numeroFormateado);

    }
}
