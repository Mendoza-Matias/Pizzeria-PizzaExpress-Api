package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.user.Cliente;
import com.mk.pizzaexpress.domain.entity.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    boolean existClave(String clave);
    boolean existEmail(String email);
    Optional <Cliente> findByEmail (String email);


}
