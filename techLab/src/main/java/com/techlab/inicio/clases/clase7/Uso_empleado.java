package com.techlab.inicio.clases.clase7;
import java.util.*;

public class Uso_empleado {
    public static void main(String[] args) {
       /* ejemplo 1
        Empleado empleado1 = new Empleado("Gustavo",100000,1992,12,14);
        Empleado empleado2 = new Empleado("Ezequiel",120000,2000,5,1);
        Empleado empleado3 = new Empleado("Carolina",130000,1992,12,14);

        System.out.println("Nombre:" + empleado1.getNombre() + " Sueldo: " + empleado1.getSueldo() + " Fecha de Alta: " + empleado1.getAltaContrato());
        System.out.println("Nombre:" + empleado2.getNombre() + " Sueldo: " + empleado2.getSueldo() + " Fecha de Alta: " + empleado2.getAltaContrato());
        System.out.println("Nombre:" + empleado3.getNombre() + " Sueldo: " + empleado3.getSueldo() + " Fecha de Alta: " + empleado3.getAltaContrato());
        */
        Empleado[] misEmpleados = new Empleado[3];
        misEmpleados[0] = new Empleado("Gustavo",100000,1992,12,14);
        misEmpleados[1] = new Empleado("Ezequiel",120000,2000,5,1);
        misEmpleados[2] = new Empleado("Carolina",130000,1992,12,14);

        for(int i=0;i<3;i++){
            misEmpleados[i].subeSueldo(5);
            System.out.println("Nombre: " + misEmpleados[i].getNombre() + " Sueldo: " + misEmpleados[i].getSueldo() + " Fecha de alta: " + misEmpleados[i].getAltaContrato());
        }
    }
}
class Empleado {
    public Empleado(String nombre, double sue , int anio, int mes , int dia){
        this.nombre = nombre;
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(anio,mes - 1,dia);
        altaContrato = calendario.getTime();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
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
}