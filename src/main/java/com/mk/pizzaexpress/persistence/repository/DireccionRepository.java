package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Integer> {
}
