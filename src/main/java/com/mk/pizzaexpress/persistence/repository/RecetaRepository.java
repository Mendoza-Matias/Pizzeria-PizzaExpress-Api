package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.productos.Pizza;
import com.mk.pizzaexpress.domain.entity.recetas.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RecetaRepository extends JpaRepository<Receta,Integer> {
    Optional <Receta> findByPizza (Pizza pizza);

    boolean existsByNombre(String nombre);

}
