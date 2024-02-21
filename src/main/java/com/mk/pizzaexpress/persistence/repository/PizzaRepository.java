package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.productos.Pizza;
import com.mk.pizzaexpress.domain.entity.enums.TipoDePizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
    Pizza findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    boolean existsByTipoDePizza(TipoDePizza tipoDePizza);

}
