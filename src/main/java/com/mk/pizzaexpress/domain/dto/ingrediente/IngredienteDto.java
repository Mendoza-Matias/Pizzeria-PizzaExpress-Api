package com.mk.pizzaexpress.domain.dto.ingrediente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class IngredienteDto {

    private String nombre;
}
