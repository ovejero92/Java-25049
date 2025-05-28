package com.techlab.inicio.clases.clase6;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Crear Cliente
        System.out.print("Ingrese su nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = entrada.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String correo = entrada.nextLine();

        Cliente cliente = new Cliente(nombre, correo, apellido);

        // Crear Pedido y agregar productos
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

        // Menú de opciones
        while (true) {
            System.out.println("\nBienvenido/a " + cliente.getNombreCompleto() + " (" + cliente.getTipo() + ")");
            System.out.println("Correo: " + cliente.getCorreo());

            System.out.println("\n¿Qué desea hacer?");
            System.out.println("1 - Buscar un producto");
            System.out.println("2 - Ver total y finalizar");
            System.out.println("3 - editar perfil");
            System.out.print("Opción: ");
            String opcion = entrada.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Ingrese el nombre a buscar: ");
                String busqueda = entrada.nextLine();
                pedido.buscarProducto(busqueda);
            } else if (opcion.equals("2")) {
                System.out.println("\nProductos en el carrito:");
                pedido.mostrarProductos();
                System.out.println("Costo total del carrito: " + Utils.separadorDeMiles(pedido.calcularTotal()));
                break;
            }else if(opcion.equals("3")){

                System.out.print("Volvé a ingresar tu nombre: ");
                String editNombre = entrada.nextLine();

                System.out.print("Volvé a ingresar tu apellido: ");
                String editApellido = entrada.nextLine();

                System.out.print("Volvé a ingresar tu correo electrónico: ");
                String editCorreo = entrada.nextLine();

                cliente.setNombre(editNombre);
                cliente.setApellido(editApellido);
                cliente.setCorreo(editCorreo);
            }
            else {
                System.out.println("Opción no válida.");
            }
        }

        entrada.close();  // buena práctica

    }
}
