package com.mk.pizzaexpress.domain.dto.administrador;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearAdministradorDto {

    String nombre;

    String correo;

    String clave;

    Rol rol;

}
