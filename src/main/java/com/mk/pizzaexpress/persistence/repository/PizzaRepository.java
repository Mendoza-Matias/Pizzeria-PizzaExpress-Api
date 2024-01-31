package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Integer> {


}
