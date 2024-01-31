package com.mk.pizzaexpress.domain.dto.proveedor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearProveedorDto {

    String nombre;
    String correo;
    String clave;
}
