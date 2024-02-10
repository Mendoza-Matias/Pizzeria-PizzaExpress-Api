package com.mk.pizzaexpress.domain.dto.pedido;

import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PedidoPizzaDto {

    private PizzaDto pizzas;

    private int cantidad;
}
