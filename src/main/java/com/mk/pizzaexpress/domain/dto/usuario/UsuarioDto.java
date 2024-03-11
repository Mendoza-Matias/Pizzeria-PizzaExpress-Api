package com.mk.pizzaexpress.domain.dto.usuario;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.management.relation.Role;

@Data
@Builder
@AllArgsConstructor
public class UsuarioDto {
    private int id;
    private String nombre;
    private String email;
    private Rol rol;
}
