package com.mk.pizzaexpress.domain.dto.bebida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BebidaDto {
    String nombre;
    float precio;
    String marca;
    float litros;
}
