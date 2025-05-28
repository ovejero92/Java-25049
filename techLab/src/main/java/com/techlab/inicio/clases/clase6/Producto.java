package com.techlab.inicio.clases.clase6;

public class Producto {
  private String nombre;
  private double precio;
  private int stock;
  private int cantidad;
  private double descuento;

  public Producto(String nombre, double precio) {
      this.nombre = nombre;
      this.precio = precio;
      this.stock = 50;
      this.cantidad = 1;
      this.descuento = 0;
  }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getCantidad() {
        return cantidad;
    }


    String getNombre() {
      return Utils.capitalize(nombre);
    }

    void print(){
        System.out.println("********************");
        System.out.println("*Nombre: " + Utils.capitalize(this.nombre));
        System.out.println("*Precio: "+ Utils.separadorDeMiles(this.precio));
        System.out.println("*Stock: " + this.stock);
        System.out.println("*Cantidad: " + this.cantidad);
        System.out.println("********************");
    }
    void agregarDescuento(double descuento){
      if(this.descuento >= 50){
          System.out.println("no podes aplicar mas del 50%");
      } else {
          this.descuento = descuento;
      }
    }
    void agregarCantidad(int cantidad){this.cantidad += cantidad;}
    boolean contieneNombre(String busqueda){
      return this.nombre.contains(busqueda);
    }
    double calcularPrecioTotal(){
      double precioSinDescuento = this.precio * this.cantidad;

      double descuento = 1 - (this.descuento / 100);
      return precioSinDescuento * descuento;
    }

}
