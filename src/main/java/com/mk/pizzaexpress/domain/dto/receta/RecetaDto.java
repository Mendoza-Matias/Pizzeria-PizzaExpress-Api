package com.mk.pizzaexpress.domain.dto.receta;

import com.mk.pizzaexpress.domain.dto.ingrediente.IngredienteDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RecetaDto {

    PizzaDto pizza;

    IngredienteDto ingrediente;
}
