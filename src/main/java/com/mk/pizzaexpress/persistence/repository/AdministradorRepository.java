package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.Pedido;
import com.mk.pizzaexpress.domain.entity.user.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador,Integer> {


   Optional<Administrador> findByEmail(String email);
   boolean existClave(String clave);
   boolean existEmail(String email);
}
