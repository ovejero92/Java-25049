package com.techlab.inicio.clase3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Listas {
    public static void main(String[] args) {

        // Crear un ArrayList con algunos nombres
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Gustavo", "Ezequiel", "Romina"));

        // Mostrar el ArrayList original
        System.out.println("ArrayList original: " + nombres);

        // add(): Agregar un elemento al final de la lista
        nombres.add("Lucía");
        System.out.println("Después de add(\"Lucía\"): " + nombres);

        // add(index, element): Insertar un elemento en una posición específica
        nombres.add(1, "María");
        System.out.println("Después de add(1, \"María\"): " + nombres);


        // get(index): Obtener el elemento en la posición especificada
        String nombreEnPosicion2 = nombres.get(2);
        System.out.println("Elemento en la posición 2: " + nombreEnPosicion2);

        // set(index, element): Reemplazar el elemento en la posición especificada
        nombres.set(2, "Carlos");
        System.out.println("Después de set(2, \"Carlos\"): " + nombres);

        // remove(index): Eliminar el elemento en la posición especificada
        nombres.remove(3);
        System.out.println("Después de remove(3): " + nombres);

        // remove(Object): Eliminar la primera ocurrencia del elemento especificado
        nombres.remove("María");
        System.out.println("Después de remove(\"María\"): " + nombres);

        // contains(Object): Verificar si la lista contiene un elemento específico
        boolean contieneGustavo = nombres.contains("Gustavo");
        System.out.println("¿Contiene \"Gustavo\"?: " + contieneGustavo);

        // indexOf(Object): Obtener la posición de la primera ocurrencia del elemento
        int indiceDeCarlos = nombres.indexOf("Carlos");
        System.out.println("Índice de \"Carlos\": " + indiceDeCarlos);

        // size(): Obtener el tamaño de la lista
        int tamaño = nombres.size();
        System.out.println("Tamaño de la lista: " + tamaño);

        // isEmpty(): Verificar si la lista está vacía
        boolean estaVacia = nombres.isEmpty();
        System.out.println("¿La lista está vacía?: " + estaVacia);

        // toArray(): Convertir la lista en un array
        Object[] arrayNombres = nombres.toArray();
        System.out.println("Array convertido desde ArrayList: " + Arrays.toString(arrayNombres));

        // sort(): Ordenar la lista
        Collections.sort(nombres);
        System.out.println("Después de ordenar: " + nombres);

        // clear(): Eliminar todos los elementos de la lista
        nombres.clear();
        System.out.println("Después de clear(): " + nombres);
        System.out.println("¿La lista está vacía después de clear()?: " + nombres.isEmpty());

        // 14. for-each para imprimir uno por uno
        System.out.println("for-each:");
        for (String alumno : nombres) {
            System.out.println(alumno);
        }

    }
}
