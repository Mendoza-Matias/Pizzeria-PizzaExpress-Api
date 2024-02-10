package com.mk.pizzaexpress.domain.dto.cliente;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ClienteDto {

    private int id;

    private String nombre;

    private String email;

    private int telefono;

    private Rol rol;

    private String direccion;

    private String localidad;

}
