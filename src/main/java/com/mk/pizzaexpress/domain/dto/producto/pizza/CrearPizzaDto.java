package com.mk.pizzaexpress.domain.dto.producto.pizza;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDePizza;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearPizzaDto {

    private int id;

    @NotNull
    @Size(max = 45)
    private String nombre;

    private TipoDePizza tipoDePizza;

    @Positive
    private int precio;

    private Medida medida;

}
