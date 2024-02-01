package com.mk.pizzaexpress.domain.dto.receta;

import com.mk.pizzaexpress.domain.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CrearRecetaDto {

    String nombre;

    Pizza pizza;

    List<Integer> idIngredientes;
}
