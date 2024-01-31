package com.mk.pizzaexpress.domain.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CrearPedidoDto {

    List<Integer> idPizzas;

    List<Integer> idBebidas;
}
