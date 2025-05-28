package com.techlab.inicio.clases.clase6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Pedido pedido = new Pedido();

        Producto monitor = new Producto("monitor", 2000);
        monitor.agregarDescuento(20);
        monitor.agregarCantidad(9);

        Producto microfono = new Producto("microfono", 4000);
        microfono.agregarDescuento(10);
        microfono.agregarCantidad(29);

        Producto webcam = new Producto("webcam", 1000);
        webcam.agregarDescuento(5);
        webcam.agregarCantidad(19);

        pedido.agregarProducto(monitor);
        pedido.agregarProducto(microfono);
        pedido.agregarProducto(webcam);

        pedido.mostrarProductos();
        System.out.println("Costo total del carrito: " + Utils.separadorDeMiles(pedido.calcularTotal()));

        // Búsqueda de productos
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el nombre a buscar: ");
        String busqueda = entrada.nextLine();

        pedido.buscarProducto(busqueda);

        //final
    }
}

