package com.mk.pizzaexpress.domain.dto.usuario;

import com.mk.pizzaexpress.domain.entity.Direccion;
import com.mk.pizzaexpress.domain.entity.pedidos.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ClienteDto {

    private int id;

    private String nombre;

    private String email;

    private int telefono;

    private Direccion direccion;

    private List <Pedido> pedidos;
}
