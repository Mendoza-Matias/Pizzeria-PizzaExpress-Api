package com.mk.pizzaexpress.domain.dto.pedido;

import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.DatosClienteDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.DatosBebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.DatosPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class PedidoDto {

    private int id;

    private DatosClienteDto cliente;

    private DatosPizzaDto pizza;

    private DatosBebidaDto bebida;

    private int cantidadDePizzas;

    private int cantidadDeBebidas;

    private EstadoPedido estadoPedido;
}
