package com.mk.pizzaexpress.domain.dto.cliente;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ClienteDto {

    int id;

    String nombre;

    String email;

    int telefono;

    Rol rol;

    String direccion;

    String localidad;

}
