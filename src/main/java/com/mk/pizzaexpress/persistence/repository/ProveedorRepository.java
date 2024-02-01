package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.user.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {

    boolean existClave(String clave);
    boolean existEmail(String email);
}
