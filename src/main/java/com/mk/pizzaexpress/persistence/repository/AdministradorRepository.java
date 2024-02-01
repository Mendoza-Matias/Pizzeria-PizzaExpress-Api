package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.user.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador,Integer> {

    boolean existsByEmail(String email);

    boolean existsByClave(String clave);
    Optional<Administrador> findByEmail(String email);
}
