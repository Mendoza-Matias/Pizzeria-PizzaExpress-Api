package com.mk.pizzaexpress.domain.dto.bebida;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearBebidaDto {

    String nombre;

    float precio;

    Medida medida;

    String marca;

    float litros;

    int stock;

    String urlImagen;
}
