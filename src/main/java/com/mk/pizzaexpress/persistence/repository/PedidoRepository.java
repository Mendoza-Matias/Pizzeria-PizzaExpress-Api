package com.mk.pizzaexpress.persistence.repository;

import com.mk.pizzaexpress.domain.entity.pedidos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
    Optional<Pedido> findByNumeroDePedido(int numeroDePedido);

}
