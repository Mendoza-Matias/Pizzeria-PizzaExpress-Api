package com.mk.pizzaexpress.domain.dto.ingrediente;

import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import com.mk.pizzaexpress.domain.entity.Receta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CrearIngredienteDto {

    private String nombre;

    private int stock;
}
