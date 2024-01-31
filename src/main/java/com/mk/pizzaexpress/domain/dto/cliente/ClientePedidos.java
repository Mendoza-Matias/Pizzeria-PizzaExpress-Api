package com.mk.pizzaexpress.domain.dto.cliente;

import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ClientePedidos {

    List<PedidoDto> pedidos;
}
