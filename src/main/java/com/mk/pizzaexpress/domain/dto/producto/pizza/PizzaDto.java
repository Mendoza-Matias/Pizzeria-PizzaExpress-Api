package com.mk.pizzaexpress.domain.dto.producto.pizza;


import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDePizza;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PizzaDto {

    private int id;

    private String nombre;

    private TipoDePizza tipoDePizza;

    private float precio;

    private Medida medida;

    private String urlImagen;

}
