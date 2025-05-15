package com.techlab.inicio.clases.clase5;

public class Main {
    public static void main(String[] args) {
        Producto teclado = new Producto("teclado red draGon",20000);
        Producto mouse = new Producto(2000,"Logitec");
        teclado.nombre = "teclado red draGon";
        teclado.precio = 20000;

        teclado.descontarStock();

        double precioConDescuento = teclado.precioConDescuento();
        System.out.println(precioConDescuento);
        System.out.println(teclado.capitalize());

    }
}
