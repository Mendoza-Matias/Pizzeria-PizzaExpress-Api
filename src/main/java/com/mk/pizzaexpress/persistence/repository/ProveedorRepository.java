package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.usuarios.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProveedorRepository extends JpaRepository<Proveedor,Integer>{

    Optional<Proveedor> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByClave(String clave);
}
