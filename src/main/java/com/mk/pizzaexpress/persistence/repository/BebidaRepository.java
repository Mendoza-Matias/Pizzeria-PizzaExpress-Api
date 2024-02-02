package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida,Integer> {
    Bebida findByNombre(String nombre);
    boolean existsByMarca(String nombre);
}
