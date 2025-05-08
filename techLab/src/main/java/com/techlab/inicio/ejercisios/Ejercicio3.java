package com.techlab.inicio.ejercisios;
import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<String> productosDesprolijos = new ArrayList<>();
        productosDesprolijos.add(" té CHAi ");
        productosDesprolijos.add("  CAFÉ  ");
        productosDesprolijos.add("JuGO de naRAnja ");
        productosDesprolijos.add(" AGUA ");
        productosDesprolijos.add("  leCHe  ");

        ArrayList<String> productosLimpios = limpiarLista(productosDesprolijos);

        System.out.println("Lista limpia:");
        for (String p : productosLimpios) {
            System.out.println(p);
        }
    }

    public static ArrayList<String> limpiarLista(ArrayList<String> lista) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String nombre : lista) {
            resultado.add(formatearNombre(nombre));
        }
        return resultado;
    }

    public static String formatearNombre(String nombre) {
        nombre = nombre.trim().toLowerCase();
        String[] partes = nombre.split(" ");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : partes) {
            if (!palabra.isEmpty()) {
                resultado.append(Character.toUpperCase(palabra.charAt(0)))
                        .append(palabra.substring(1))
                        .append(" ");
            }
        }
        return resultado.toString().trim();
    }

}
