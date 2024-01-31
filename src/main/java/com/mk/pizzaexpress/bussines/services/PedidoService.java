package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;

import java.util.List;


public interface PedidoService {

    List<PedidoDto> listarTodosLosPedidos();

    PedidoDto listarPedidoPorNumeroDePedido(int numeroDePedido);

    PedidoDto crearUnPedido(int idUsuario , CrearPedidoDto pedido);

    void restarStockDeIngredientesParaPizza (PizzaDto pizza);

    void restarStockDeBebidas (BebidaDto bebida);

    PedidoDto editarUnPedido (int numeroDePedido, CrearPedidoDto pedido);

    PedidoDto modificarEstadoDePedido(int numeroPedido);

    PedidoDto eliminarUnPedidoPorNumeroDePedido (int numeroDePedido);
}
