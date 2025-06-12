package com.techlab.inicio.clases.clase7;

public class Main {
    public static void main(String[] args) {
        /*
        Bebida p1 = new Bebida("Coca-cola", 17623,14324);
        Alimento p2 = new Alimento("Pan integral",134143,12341);

        p1.mostrarInfo();
        System.out.println("-----------------");
        p2.mostrarInfo();*/

        Producto[] productos = {
                new Bebida("Jugo de naranja",5,12131),
                new Alimento("Pizza",12313,12412),
                new Alimento("Hamburguesa", 13123123,1243)
        };

//ERROR -> Alimento cambio = (Alimento) productos[0];

        for(Producto prod: productos){
            System.out.println();
            if(prod instanceof Alimento){
                Alimento comida = (Alimento) prod;
                System.out.println("Comida: ");
                comida.mostrarInfo();
            } else if(prod instanceof Bebida) {
                Bebida bebida = (Bebida) prod;
                System.out.println("Comida: ");
                bebida.mostrarInfo();
            }
        }

    }
}
