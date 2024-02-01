package com.mk.pizzaexpress.domain.dto.pizza;

import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import com.mk.pizzaexpress.domain.entity.enums.Medida;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PizzaDto {

    String nombre;

    float precio;

    Medida medida;

    RecetaDto receta;

    String urlImagen;
}
