package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.user.Cliente;
import com.mk.pizzaexpress.domain.entity.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    //Usuario obtenerClientePorCorreo(String correo);

    //Usuario obtenerClientePorDireccion(String direccion);

    //Usuario obtenerClientePorLocalidad(String localidad);

}
