package com.mk.pizzaexpress.domain.dto.receta.recetaIngrediente;

import com.mk.pizzaexpress.domain.dto.ingrediente.IngredienteDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RecetaIngredienteDto {

    private int ingredienteId;

    private String nombre;

    private int cantidad;
}
