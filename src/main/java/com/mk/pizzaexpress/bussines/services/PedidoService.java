package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;

import java.util.List;


public interface PedidoService {

    List<PedidoDto> listarTodosLosPedidos();

    PedidoDto obtenerPedidoPorNumeroDePedido(int numeroDePedido);

    PedidoDto crearUnPedido(int usuarioId , CrearPedidoDto crearPedidoDto , List<Integer> pizzasIds,List<Integer> bebidaIds);

    void restarStockDeIngredientesParaPizza (PizzaDto pizza);

    void restarStockDeBebidas (BebidaDto bebida);

    PedidoDto editarUnPedido (int numeroDePedido,int clienteId, CrearPedidoDto crearPedidoDto,List<Integer> pizzasIds,List<Integer> bebidaIds);

    PedidoDto modificarEstadoDePedido(int numeroPedido);

    PedidoDto eliminarUnPedidoPorNumeroDePedido (int numeroDePedido);




}
