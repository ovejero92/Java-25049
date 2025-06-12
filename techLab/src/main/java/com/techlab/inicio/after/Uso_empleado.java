package com.techlab.inicio.after;

import java.util.*;

public class Uso_empleado {
    public static void main(String[] args) {
        Jefatura jefe_RRHH = new Jefatura("Fulanita",140000,2020,4,6);
        jefe_RRHH.estableveIncentivo(4000);

        Empleado[] misEmpleados = new Empleado[5];
        misEmpleados[0] = new Empleado("Gustavo",100000,1992,12,14);
        misEmpleados[1] = new Empleado("Ezequiel",120000,2000,5,1);
        misEmpleados[2] = new Empleado("Carolina",130000,1992,12,14);
        misEmpleados[3] = jefe_RRHH;
        misEmpleados[4] = new Jefatura("Maria",140000,2010,7,4);

        Jefatura jefa_finanzas = (Jefatura) misEmpleados[4];
        jefa_finanzas.estableveIncentivo(2500);

        Jefatura jefe_ventas = (Jefatura) misEmpleados[0];
        jefe_ventas.estableveIncentivo(392392329);


    }
}
class Empleado implements infoGral {
    public Empleado(String nombre, double sue , int anio, int mes , int dia){
        this.nombre = nombre;
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(anio,mes - 1,dia);
        altaContrato = calendario.getTime();
        ++IdSiguiente;
        Id = IdSiguiente;
    }

    public String getNombre() {
        return nombre + "Id: " + Id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double dameSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public Date getAltaContrato() {
        return altaContrato;
    }
    public void subeSueldo(double procentaje){
        double aumento = sueldo*procentaje/100;
        sueldo+=aumento;
    }
    public void setAltaContrato(Date altaContrato) {
        this.altaContrato = altaContrato;
    }

    private String nombre;
    private double sueldo;
    private Date altaContrato;
    private static int IdSiguiente;
    private int Id;

    @Override
    public void info() {

    }
}
class Jefatura extends Empleado{
    public Jefatura(String nombre, double sue , int anio, int mes , int dia){
        super(nombre,sue,anio,mes,dia);
    }

    public void info(){}

    final public void estableveIncentivo(double b) { incentivo = b ;}

    public double dameSueldo(){
        double sueldoJefe = super.dameSueldo();
        return sueldoJefe + incentivo;
    }

    private double incentivo;
}