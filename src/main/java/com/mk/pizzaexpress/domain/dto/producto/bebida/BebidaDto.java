package com.mk.pizzaexpress.domain.dto.producto.bebida;

import com.mk.pizzaexpress.domain.entity.enums.TipoDeBebida;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BebidaDto {

    private  int id;

    private String marca;

    private TipoDeBebida tipoDeBebida;

    private int stock;

    private float precio;

    private float litros;

    private String urlImagen;
}
