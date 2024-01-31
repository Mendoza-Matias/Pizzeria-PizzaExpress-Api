package com.mk.pizzaexpress.domain.dto.pedido;


import com.mk.pizzaexpress.domain.dto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PedidoDto {

    int numeroDePedido;

    EstadoPedido estadoPedido;

    ClienteDto cliente;

    List<PizzaDto> pizza;

    List<BebidaDto> bebida;
}
