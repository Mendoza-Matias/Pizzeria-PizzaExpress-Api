package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;

import java.util.List;


public interface PedidoService {
    List <PedidoDto> listarTodosLosPedidos();
    List<PedidoDto> obtenerPedidosPorClienteId(int clienteId);
    PedidoDto crearPedido(int clienteId , CrearPedidoDto crearPedido);
    PedidoDto editarPedido(int pedidoId , CrearPedidoDto crearPedido);
    PedidoDto modificarEstadoDePedido(int pedidoId);
    PedidoDto eliminarUnPedido (int pedidoId);
}
