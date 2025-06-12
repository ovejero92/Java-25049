package com.techlab.inicio.clases.clase7;

// Subclase que hereda de Producto
public class Bebida extends Producto {
    private int volumenML;

    public Bebida(String nombre, int volumenML, double precio) {
        super(nombre,precio); // Llama al constructor de Producto
        this.volumenML = volumenML;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("producto: " + getNombre());

        System.out.println("Volumen: " + volumenML + " ml");
    }
}