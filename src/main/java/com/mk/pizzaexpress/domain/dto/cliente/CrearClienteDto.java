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

    String nombre;

    int telefono;

    String email;

    String clave;

    String direccion;

    String localidad;
}
