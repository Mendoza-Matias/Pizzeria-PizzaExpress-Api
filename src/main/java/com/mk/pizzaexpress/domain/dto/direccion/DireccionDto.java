package com.mk.pizzaexpress.domain.dto.direccion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDto {

    private String direccion;

    private String localidad;

    private String provincia;

}
