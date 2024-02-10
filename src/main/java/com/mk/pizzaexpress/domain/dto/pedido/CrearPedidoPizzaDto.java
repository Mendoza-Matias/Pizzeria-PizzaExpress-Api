package com.mk.pizzaexpress.domain.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CrearPedidoPizzaDto {

    private int pizzaId;

    private int cantidad;
}
