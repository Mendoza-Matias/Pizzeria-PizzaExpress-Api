package com.mk.pizzaexpress.domain.dto.cliente;

import com.mk.pizzaexpress.domain.entity.Pedido;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ClienteDto {

    int id;

    String nombre;

    int telefono;

    Rol rol;

    String direccion;

    String localidad;

}
