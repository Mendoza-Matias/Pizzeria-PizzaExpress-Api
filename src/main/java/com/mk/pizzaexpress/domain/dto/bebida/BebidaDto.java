package com.mk.pizzaexpress.domain.dto.bebida;

import com.mk.pizzaexpress.domain.entity.enums.TipoDeBebida;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BebidaDto {

    String marca;

    TipoDeBebida tipoDeBebida;

    float precio;

    float litros;
}
