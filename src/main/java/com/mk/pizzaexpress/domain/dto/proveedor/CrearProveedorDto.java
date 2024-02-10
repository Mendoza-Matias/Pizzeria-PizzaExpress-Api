package com.mk.pizzaexpress.domain.dto.proveedor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearProveedorDto {

    private String nombre;

    private String email;

    private String clave;
}
