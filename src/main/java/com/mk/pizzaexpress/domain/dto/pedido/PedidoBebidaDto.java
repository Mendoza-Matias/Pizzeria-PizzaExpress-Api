package com.mk.pizzaexpress.domain.dto.pedido;

import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PedidoBebidaDto {

    private BebidaDto bebidas;

    private int cantidad;
}
