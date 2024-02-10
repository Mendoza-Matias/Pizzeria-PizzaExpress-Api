package com.mk.pizzaexpress.domain.dto.receta;

import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.dto.receta.recetaIngrediente.RecetaIngredienteDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RecetaDto {

    private String nombre;

    private PizzaDto pizza;

    private RecetaIngredienteDto recetaIngredienteDto;
}
