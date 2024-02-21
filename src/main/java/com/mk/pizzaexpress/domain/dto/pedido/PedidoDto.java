package com.mk.pizzaexpress.domain.dto.pedido;



import com.mk.pizzaexpress.domain.dto.usuario.UsuarioDto;
import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PedidoDto {

    private UsuarioDto usuarioDto;

    private int numeroDePedido;

    private EstadoPedido estadoPedido;

    private List<PedidoBebidaDto> bebidasPedidas;

    private List<PedidoPizzaDto> pizzasPedidas;
}
