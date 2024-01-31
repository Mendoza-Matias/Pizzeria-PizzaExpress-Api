package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecetaRepository extends JpaRepository<Receta,Integer> {
}
