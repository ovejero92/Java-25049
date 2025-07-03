package com.TechLab.spring.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado; // por ejemplo: "EN_PROCESO", "ENTREGADO"

    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    private List<Producto> productos;
}
