package com.techlab.inicio.clases.clase3;
import java.util.Arrays;

public class ejemplos {
    public static void main(String[] args) {
        String nombre = "gustavo";
        String apellido = "ovejero";


        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1);
        apellido = apellido.toUpperCase().charAt(0) + apellido.substring(1);

        String url = "https://gamma.app/docs/Clase03-b3ctilf3i3y799m?mode=doc";
        String[] partesUrl = url.split("/");

        System.out.println(Arrays.toString(partesUrl));

    }


}
