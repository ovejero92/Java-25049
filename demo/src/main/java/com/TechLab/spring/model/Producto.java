package com.TechLab.spring.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@AllArgsConstructor
@Getter
@Table(name = "productos")
public class Producto {
    private String nombre;
    private int precio;
    private String categoria;


}
