package com.TechLab.spring.repository;

import com.TechLab.spring.model.Role;
import com.TechLab.spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String name);
}