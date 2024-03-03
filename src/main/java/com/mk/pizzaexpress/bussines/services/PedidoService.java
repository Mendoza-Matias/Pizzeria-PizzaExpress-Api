package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;

import java.util.List;


public interface PedidoService {

    List<PedidoDto> listarTodosLosPedidos();

    PedidoDto obtenerPedidoPorNumeroDePedido(int numeroDePedido);

    PedidoDto CrearPedidoDePizza (int clienteId  , int pizzaId , int cantidad);

    PedidoDto CrearPedidoDeBebida (int clienteId  , int bebidaId , int cantidad);

    PedidoDto modificarPedidoDePizza(int id, int pizzaId,int cantidad);

    PedidoDto modificarPedidoDeBebida(int id , int bebidaId , int cantidad);

    PedidoDto modificarEstadoDePedido(int id);

    PedidoDto eliminarUnPedido (int id);
}
