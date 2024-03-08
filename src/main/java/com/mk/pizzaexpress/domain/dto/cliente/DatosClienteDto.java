package com.mk.pizzaexpress.domain.dto.cliente;

import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class DatosClienteDto {

    private int id;

    private String nombre;
}
