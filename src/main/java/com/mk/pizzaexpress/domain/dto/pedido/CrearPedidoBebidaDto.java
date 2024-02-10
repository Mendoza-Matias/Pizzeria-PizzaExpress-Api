package com.mk.pizzaexpress.domain.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearPedidoBebidaDto {

    private int bebidaId;

    private int cantidad;
}
