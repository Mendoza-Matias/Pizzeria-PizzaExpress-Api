package com.mk.pizzaexpress.domain.dto.producto.bebida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BebidaPorPrecioDto {

    private String nombre;

    private String marca;

    private float litros;
}
