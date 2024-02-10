package com.mk.pizzaexpress.domain.dto.producto.bebida;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDeBebida;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearBebidaDto {

    String marca;

    TipoDeBebida tipoDeBebida;

    float precio;

    Medida medida;

    float litros;

    int stock;

    String urlImagen;
}
