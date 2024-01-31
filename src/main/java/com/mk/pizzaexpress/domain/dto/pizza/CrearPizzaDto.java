package com.mk.pizzaexpress.domain.dto.pizza;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDePizza;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearPizzaDto {

    String nombre;

    TipoDePizza tipoDePizza;
    float precio;
    Medida medida;
}
