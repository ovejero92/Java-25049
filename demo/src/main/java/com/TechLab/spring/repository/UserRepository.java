package com.TechLab.spring.repository;

import com.TechLab.spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByUsername(String name);
}
