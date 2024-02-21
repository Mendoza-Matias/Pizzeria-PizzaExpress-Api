package com.mk.pizzaexpress.domain.dto.ingrediente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearIngredienteDto {

    private String nombre;

    private int stock;
}
