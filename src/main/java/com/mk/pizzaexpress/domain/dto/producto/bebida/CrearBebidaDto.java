package com.mk.pizzaexpress.domain.dto.producto.bebida;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDeBebida;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearBebidaDto {

    private int id;

    @NotNull
    private String marca;

    @NotNull
    private TipoDeBebida tipoDeBebida;

    @Positive
    private int precio;

    @NotNull
    private Medida medida;

    @PositiveOrZero
    private float litros;



}
