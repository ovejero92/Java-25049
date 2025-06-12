package com.techlab.inicio.clases.clase7;

public abstract class Producto {
   public Producto(String nombre, double precio) {
       this.nombre = nombre;
       this.precio = precio;
   }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarInfo();

   private String nombre;
   private double precio;
}
