package com.TechLab.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
