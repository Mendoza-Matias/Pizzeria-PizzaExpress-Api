package com.mk.pizzaexpress.domain.dto.administrador;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AdministradorDto {

    private int id;

    private String nombre;

    private Rol rol;
}
