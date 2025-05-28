package com.techlab.inicio.clases.clase6;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Producto> carrito;

    public Pedido() {
        this.carrito = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){    carrito.add(producto);}
    void mostrarProductos(){
        for(Producto producto: carrito){
            producto.print();
        }
    }

    public double calcularTotal(){
        double total = 0;
        for(Producto producto: carrito){
            total += producto.calcularPrecioTotal();
        }
        return total;
    }

    public void buscarProducto(String nombre) {
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto producto : carrito) {
            if (producto.contieneNombre(nombre)) {
                encontrados.add(producto);
            }
        }

        if (encontrados.isEmpty()) {
            System.out.printf("No encontramos productos que coincidan con <%s>%n", nombre);
        } else {
            System.out.println("PRODUCTOS ENCONTRADOS:");
            for (Producto producto : encontrados) {
                producto.print();
            }
        }


    }
    }
