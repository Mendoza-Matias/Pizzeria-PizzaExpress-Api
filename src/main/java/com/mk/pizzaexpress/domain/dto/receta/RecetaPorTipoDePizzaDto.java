package com.mk.pizzaexpress.domain.dto.receta;

import com.mk.pizzaexpress.domain.entity.enums.TipoDePizza;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RecetaPorTipoDePizzaDto {

    TipoDePizza tipoDePizza;
}
