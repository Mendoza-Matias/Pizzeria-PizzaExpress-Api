package com.mk.pizzaexpress.domain.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrearClienteDto {

    private String nombre;

    private int telefono;

    private String email;

    private String clave;

    private String direccion;

    private String localidad;
}
