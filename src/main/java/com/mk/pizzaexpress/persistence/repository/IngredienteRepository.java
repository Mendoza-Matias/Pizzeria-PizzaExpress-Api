package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente,Integer> {
    boolean existsByNombre(String nombre);
}
