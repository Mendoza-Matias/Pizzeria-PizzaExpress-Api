package com.mk.pizzaexpress.domain.dto.ingrediente;

import com.mk.pizzaexpress.domain.entity.Receta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CrearIngredienteDto {

    String nombre;

    int stock;

    List <Receta> recetas;
}
