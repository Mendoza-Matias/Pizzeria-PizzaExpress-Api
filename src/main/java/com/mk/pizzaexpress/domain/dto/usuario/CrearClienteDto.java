package com.mk.pizzaexpress.domain.dto.usuario;

import com.mk.pizzaexpress.domain.entity.Direccion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearClienteDto {

    private int id;

    private String nombre;

    private String email;

    private int telefono;

    private Direccion direccion;

    private String clave;
}
