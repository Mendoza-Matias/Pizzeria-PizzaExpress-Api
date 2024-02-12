package com.mk.pizzaexpress.domain.dto.ingrediente;

import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class IngredienteDto {

    int id;

    private String nombre;

    private int stock;

}
