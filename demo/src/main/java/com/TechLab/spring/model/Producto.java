package com.TechLab.spring.model;

import java.util.ArrayList;

public class Producto {
    private String nombre;
    private int precio;
    private String categoria;

    private Usuario usuario;

    private ArrayList<Long> idsProductos;
    private boolean premiun;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Long> getIdsProductos() {
        return idsProductos;
    }

    public void setIdsProductos(ArrayList<Long> idsProductos) {
        this.idsProductos = idsProductos;
    }

    public boolean isPremiun() {
        return premiun;
    }

    public void setPremiun(boolean premiun) {
        this.premiun = premiun;
    }
}
