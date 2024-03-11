package com.mk.pizzaexpress.domain.dto.cliente;

import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import com.mk.pizzaexpress.domain.entity.pedidos.Pedido;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ClienteDto {

    private int id;

    private String nombre;

    private int telefono;

    private DireccionDto direccion;

}
