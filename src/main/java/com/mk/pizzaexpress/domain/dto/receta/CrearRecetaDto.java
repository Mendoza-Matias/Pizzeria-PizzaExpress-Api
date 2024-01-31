package com.mk.pizzaexpress.domain.dto.receta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CrearRecetaDto {

    int idPizza;

    List<Integer> idIngredientes;
}
