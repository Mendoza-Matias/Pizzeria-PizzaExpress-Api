package com.mk.pizzaexpress.domain.dto.ingrediente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearIngredienteDto {

    String nombre;

    int stock;
}
