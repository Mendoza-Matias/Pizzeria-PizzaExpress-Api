package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.Pizza;
import com.mk.pizzaexpress.domain.entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;


@Repository
public interface RecetaRepository extends JpaRepository<Receta,Integer> {


    Optional <Receta> findByPizza (Pizza pizza);

    boolean existsByNombre(String nombre);

}
