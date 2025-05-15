package com.techlab.inicio.clases.clase5;

public class Producto {
    // descripcion ( atributos)
    String nombre;
    double precio;
    int stock;

    public Producto(){};
    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    public Producto( double precio, String nombre){
        this.nombre = nombre;
        this.precio = precio;
    }



    //funcionamiento ( metodos)
    void descontarStock(){
        // todo
        System.out.println("Descontando Stock");
    }
    double precioConDescuento() {
        return precio - (precio*0.2);
    }

    String capitalize() {
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
