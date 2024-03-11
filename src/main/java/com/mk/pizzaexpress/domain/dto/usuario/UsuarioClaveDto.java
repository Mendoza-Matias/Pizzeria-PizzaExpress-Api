package com.mk.pizzaexpress.domain.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UsuarioClaveDto {
    private String email;
    private String clave;
    private String nuevaClave;
}
