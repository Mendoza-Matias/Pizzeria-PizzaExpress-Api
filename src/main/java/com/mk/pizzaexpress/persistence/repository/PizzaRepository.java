package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
    Pizza findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
