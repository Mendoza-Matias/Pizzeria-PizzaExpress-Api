package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.bussines.mapper.IMapper;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import com.mk.pizzaexpress.domain.entity.Pedido;

public interface PedidoMapper extends IMapper<Pedido, PedidoDto> {

    Pedido aPedidoDeCrearPedidoDto(CrearPedidoDto crearPedidoDto);
}
