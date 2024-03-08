package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.productos.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida,Integer> {
    Optional<Bebida> findByMarca(String marca);
    boolean existsByMarca(String marca);
}
