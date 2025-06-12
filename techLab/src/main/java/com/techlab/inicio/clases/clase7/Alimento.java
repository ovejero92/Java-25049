package com.techlab.inicio.clases.clase7;

public class Alimento extends Producto{

    public Alimento(String nombre, double precio, int calorias) {
        super(nombre,precio);
        this.calorias = calorias;
    }

//    public void mostrarInfo() {
//        System.out.println("Calorias: " + calorias + " kcal");
//    }

    private int calorias;
}
