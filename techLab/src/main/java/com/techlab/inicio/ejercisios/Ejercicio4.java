package com.techlab.inicio.ejercisios;

public class Ejercicio4 {
    public static void main(String[] args) {

        System.out.println(calcualarImpuesto(1000,21));

        calcularPrecioFinal(500,10, 30);
        calcularPrecioFinal(500,10, 60);

        int[] stock = {20,35,12};
        System.out.println("Stock antes de reponer:");
        mostrarArray(stock);

        reponerStock(stock,1,10);

        System.out.println("Stock despues de reponer:");
        mostrarArray(stock);

        mostrarMensaje("Gracias por su compra.");
        mostrarMensaje("Gracias por su compra.",2);

        String clienteTipo = "nuevo";
        if(clienteTipo.equals("nuevo")){
            saludarClienteNuevo();
        } else{
            saludarClienteRecurrente();
        }

    }
    public static double calcualarImpuesto(double precio, double porcentaje) {
        return precio + (precio * porcentaje/100);
    }

    public static void calcularPrecioFinal(double precio,double descuento, int cantidad) {
        if(cantidad > 50) {
            descuento += 5;
        }
        double total = (precio-(precio*descuento/100)) * cantidad;
        System.out.println("Precio final para " + cantidad + "unidades: $" + total);
    }

    // 3. Reposición de stock
    public static void reponerStock(int[] stock, int indice, int cantidad) {
        if (indice >= 0 && indice < stock.length) {
            stock[indice] += cantidad;
        } else {
            System.out.println("Índice de stock inválido.");
        }
    }

    // Mostrar array (stock)
    public static void mostrarArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // 4. Sobrecarga de métodos mostrarMensaje
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarMensaje(String mensaje, int veces) {
        for (int i = 0; i < veces; i++) {
            System.out.println(mensaje + " (vez " + (i + 1) + ")");
        }
    }

    // 5. Modularización de saludos
    public static void saludarClienteNuevo() {
        System.out.println("¡Bienvenido al sistema, nuevo cliente!");
        mostrarMensaje("Recibiste un cupón de bienvenida.");
    }

    public static void saludarClienteRecurrente() {
        System.out.println("¡Gracias por volver!");
        mostrarMensaje("Tienes un 10% de descuento por fidelidad.", 1);
    }

}
