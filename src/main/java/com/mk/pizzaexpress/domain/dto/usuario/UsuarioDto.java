package com.mk.pizzaexpress.domain.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UsuarioDto {

    private int id;

    private String nombre;

    private String email;
}