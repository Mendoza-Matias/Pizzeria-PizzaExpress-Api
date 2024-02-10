package com.mk.pizzaexpress.domain.dto.receta;

import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearRecetaDto {

    private String nombre;

    private PizzaDto pizza;

}
