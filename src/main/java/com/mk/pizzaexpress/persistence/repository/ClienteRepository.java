package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    boolean existsByClave(String clave);
}
