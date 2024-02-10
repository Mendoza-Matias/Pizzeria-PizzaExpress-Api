package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida,Integer> {
    Optional<Bebida> findByNombre(String nombre);
    boolean existsByMarca(String nombre);
}
