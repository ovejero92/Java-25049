package com.techlab.inicio;
import java.util.ArrayList;

public class UsoEmpleado {
    public static void main(String[] args) {
        /*
        Empleado listaEmpleados[] = new Empleado[3];

        listaEmpleados[0] = new Empleado("Gustavo", 45, 2500);
        listaEmpleados[1] = new Empleado("Ezequiel", 55, 2000);
        listaEmpleados[2] = new Empleado("Pepito", 25, 2600);
         */

        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        listaEmpleados.ensureCapacity(11);

        listaEmpleados.add(new Empleado("Gustavo", 45, 2500));
        listaEmpleados.add(new Empleado("Ezequiel", 55, 2000));
        listaEmpleados.add(new Empleado("Pepito", 25, 2600));

        listaEmpleados.trimToSize();

        for (Empleado e: listaEmpleados) {
            System.out.println(e.dameDatos());
        }
    }

    }


class Empleado {
    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }
    public String dameDatos() {
        return "El empleado se llama " + nombre + " . Tiene " + edad + " años." + " y un salario de " + salario;
    }
    private String nombre;
    private int edad;
    private double salario;
}