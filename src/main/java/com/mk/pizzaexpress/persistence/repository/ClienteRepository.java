package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    Optional<Cliente> findByEmail(String email);

    boolean existsByEmail(String email);
}
