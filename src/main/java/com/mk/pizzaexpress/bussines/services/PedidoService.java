package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoBebidaDto;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoPizzaDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import com.mk.pizzaexpress.domain.entity.pedidos.PedidoBebida;
import com.mk.pizzaexpress.domain.entity.pedidos.PedidoPizza;

import java.util.List;


public interface PedidoService {

    List<PedidoDto> listarTodosLosPedidos();

    PedidoDto obtenerPedidoPorNumeroDePedido(int numeroDePedido);

    PedidoDto crearUnPedido(int clienteId , List<CrearPedidoPizzaDto> crearPedidoPizza , List<CrearPedidoBebidaDto> crearPedidoBebida);

    PedidoDto editarUnPedido (int clienteId , List<CrearPedidoPizzaDto> crearPedidoPizza , List<CrearPedidoBebidaDto> crearPedidoBebida);

    PedidoDto modificarEstadoDePedido(int numeroDePedido);

    PedidoDto eliminarUnPedidoPorNumeroDePedido (int numeroDePedido);

    //Retorna una lista de las pizzas pedidas y la cantidad
    List<PedidoPizza> obtenerPizzasPedidas(List<CrearPedidoPizzaDto> crearPedidoPizza);

    //Retorna una lista de las bebidas pedidas y su cantidad
    List<PedidoBebida> obtenerBebidasPedidas (List<CrearPedidoBebidaDto> crearPedidoBebida);






}
