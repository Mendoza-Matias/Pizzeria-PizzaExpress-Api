package com.mk.pizzaexpress.domain.dto.proveedor;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProveedorDto {

    String nombre;

    Rol rol;
}
