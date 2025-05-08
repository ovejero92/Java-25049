package com.techlab.inicio.clases.clase4;

public class Funciones {


    public static void main(String[] args) {
        String producto = "Zapatillas";
        double precioOriginal = 10000;
        double porcentajeDescuento = 10;
        double bonusFijo = 500;
        int cantidad = 60;

        double precioConDescuento = aplicarDescuento(precioOriginal, porcentajeDescuento);
        imprimirRecibo(producto + " (basico)", precioOriginal, precioConDescuento);

        double precioBonus = aplicarDescuento(precioOriginal, porcentajeDescuento,bonusFijo);
        imprimirRecibo(producto + " (premium)", precioOriginal, precioBonus);

        double precioPorCantidad = aplicarDescuentoConCantidad(precioOriginal, porcentajeDescuento,cantidad);
        imprimirRecibo(producto + " (X cantidad)", precioOriginal, precioPorCantidad);
    }

    public static void saludar() {
        System.out.print("Hola");
    }

    public static void sumar(int num1 ,int num2) {
        System.out.println("La suma es:" + (num1 + num2));
    }

    public int resta(int num1, int num2){
        return num1 - num2;
    }
    public static double aplicarDescuentoConCantidad(double precio, double porcentaje, int cantidad) {
        double descuentoFinal = porcentaje;
        if (cantidad > 50) {
            descuentoFinal = porcentaje + 5;
        }
        double descuento = precio * (descuentoFinal / 100);
        return precio - descuento;
    }
    public static void imprimirRecibo(String producto, double precioOriginal, double precioFinal) {
        System.out.println("Recibo de Compra");
        System.out.println("Producto: " + producto);
        System.out.println("Precio Original: $" + precioOriginal);
        System.out.println("Precio con Descuento: $" + precioFinal);
    }

//Este método se puede invocar múltiples veces con diferentes precios y descuentos.
// Descuento básico con porcentaje

public static double aplicarDescuento(double precio, double porcentaje) {
    double descuento = precio * (porcentaje / 100.0);
    return precio - descuento;
}

    // Descuento con bonus fijo adicional
    public static double aplicarDescuento(double precio, double porcentaje, double bonusFijo) {
        double descuento = precio * (porcentaje / 100.0);
        return precio - descuento - bonusFijo;
    }



}
