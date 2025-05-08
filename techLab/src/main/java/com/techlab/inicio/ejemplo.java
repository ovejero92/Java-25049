package com.techlab.inicio;
import java.util.Scanner;

public class ejemplo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mostrarMenu();

        int opcion = sc.nextInt();
        ejecutarOpcion(opcion);
    }

    public static void mostrarMenu() {
        System.out.println("=== Menú de Tareas ===");
        System.out.println("1. Crear tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
    }

    public static void ejecutarOpcion(int opcion) {
        if (opcion == 1) {
            crearTarea();
        } else if (opcion == 2) {
            verTareas();
        } else {
            System.out.println("¡Hasta luego!");
        }
    }

    public static void crearTarea() {
        System.out.println("Función crearTarea() aún no implementada.");
    }

    public static void verTareas() {
        System.out.println("Función verTareas() aún no implementada.");
    }

    public static void eliminarTareas() {
        System.out.println("Función crearTarea() aún no implementada.");
    }

}
