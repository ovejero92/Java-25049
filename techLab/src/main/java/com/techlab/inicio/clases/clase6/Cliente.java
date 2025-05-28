package com.techlab.inicio.clases.clase6;

public class Cliente {
    // atributos
    private String nombre;
    private String apellido;
    private String correo;
    private String tipo;

    public Cliente(String nombre, String correo, String apellido) {
        this.nombre = nombre;
        this.correo = correo;
        this.apellido = apellido;
        this.tipo = "basico";
    }

    public String getNombre() {     return nombre;   }
    public void setNombre(String nombre) {     this.nombre = nombre;   }
    public String getApellido() {     return apellido;  }
    public void setApellido(String apellido) {    this.apellido = apellido;}
    public String getNombreCompleto() { return this.nombre + " " + this.apellido; }
    public String getCorreo() {   return correo; }
    public void setCorreo(String correo) {   this.correo = correo;  }
    public String getTipo() {    return tipo;  }
    public void setTipo(String tipo) {     this.tipo = tipo; }
}
